package com.saturne.redwire.resources;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.saturne.redwire.entities.Session;
import com.saturne.redwire.entities.Stagiaire;
import com.saturne.redwire.services.SessionService;
import com.saturne.redwire.services.StagiaireService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/stagiaire")
public class StagiaireResource {

  private final StagiaireService sf;
  private final SessionService ss;

  @Autowired
  public StagiaireResource(StagiaireService sf, SessionService ss) {
    this.sf = sf;
    this.ss = ss;
  }

  @GetMapping(name = "get.stagiaire", path = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Stagiaire> getStagiaire(@RequestHeader Map<String, String> headers) {
    String token = headers.get("authorization").toString();
    Stagiaire stagiaire = this.getStagiaireFromToken(token);
    return new ResponseEntity<>(stagiaire, HttpStatus.ACCEPTED);
  }

  @PutMapping(name = "update.stagiaire", path = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Stagiaire> updateStagiaire(@RequestHeader Map<String, String> headers, @RequestBody Map<String, String> body) {
    String token = headers.get("authorization").toString();
    Stagiaire stagiaire = this.getStagiaireFromToken(token);

    stagiaire.setNom(body.get("nom").toString());
    stagiaire.setPrenom(body.get("prenom").toString());
    stagiaire.setAdresse(body.get("adresse").toString());
    stagiaire.setEmail(body.get("email").toString());
    stagiaire.setNumTelephone(body.get("numTelephone").toString());
    stagiaire.setMpass(body.get("mpass").toString());
    stagiaire.setEntreprise(Boolean.parseBoolean(body.get("entreprise").toString()));
    stagiaire.setCoordonneesEntre(body.get("coordonneesEntre").toString());

    stagiaire = sf.updateStagiaire(stagiaire);
    System.out.println("stagiaire " + stagiaire);
    return new ResponseEntity<>(stagiaire, HttpStatus.OK);
  }

  @PostMapping(name = "link.stagiaire.session", path = "/{idSession}")
  public ResponseEntity<Boolean> inscriptionSessionStagiaire(
    @RequestHeader Map<String, String> headers,
    @PathVariable("idSession") long idSession
  ) {
    Boolean status = true;
    String token = headers.get("authorization").toString();
    Stagiaire stagiaire = this.getStagiaireFromToken(token);
    Session session = ss.getSession(idSession);

    Set<Stagiaire> listStagiaires = session.getStagiaires();
    listStagiaires.add(stagiaire);
    session.setStagiaires(listStagiaires);
    ss.updateSession(session);

    return new ResponseEntity<>(status, HttpStatus.OK);
  }

  @DeleteMapping(name = "unlink.stagiaire.session", path = "/{idSession}")
  public ResponseEntity<Boolean> desinscriptionSessionStagiaire(
    @RequestHeader Map<String, String> headers,
    @PathVariable("idSession") long idSession
  ) {
    Boolean status = true;
    String token = headers.get("authorization").toString();
    Stagiaire stagiaire = this.getStagiaireFromToken(token);
    Session session = ss.getSession(idSession);

    Set<Stagiaire> listStagiaires = session.getStagiaires();
    listStagiaires.remove(stagiaire);
    session.setStagiaires(listStagiaires);
    ss.updateSession(session);

    return new ResponseEntity<>(status, HttpStatus.OK);
  }

  @GetMapping(name = "list.stagiaire", path = "list", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Session>> getStagiaireSessions(@RequestHeader Map<String, String> headers) {
    String token = headers.get("authorization").toString();
    Stagiaire stagiaire = this.getStagiaireFromToken(token);

    HashMap<String, Object> searchData = new HashMap<String, Object>();
    searchData.put("idStagiaire", stagiaire);
    List<Session> sessions = ss.getSessions(searchData);

    System.out.println("STAGIAIRE: " + stagiaire);
    System.out.println("LIST sessions :" + sessions);

    List<Session> sessions2 = ss.getSessions(new HashMap<String, Object>());
    System.out.println("LIST sessions :" + sessions2);
    return new ResponseEntity<>(sessions, HttpStatus.ACCEPTED);
  }

  private Stagiaire getStagiaireFromToken(String token) {
    Map<String, Claim> data = new HashMap<>();
    try {
      Algorithm algorithm = Algorithm.HMAC256("redwire"); //use more secure key
      JWTVerifier verifier = JWT.require(algorithm).withIssuer("auth0").build(); //Reusable verifier instance
      DecodedJWT jwt = verifier.verify(token);
      System.out.println("jwt value: " + jwt.getClaims().toString());
      data = jwt.getClaims();
    } catch (JWTVerificationException exception) {
      System.out.println(exception.getMessage());
    }
    String idsCh = data.get("idStagiaire").toString();
    idsCh = idsCh.substring(1, idsCh.length() - 1);
    return sf.findStagiaireById(Long.parseLong(idsCh));
  }
}
