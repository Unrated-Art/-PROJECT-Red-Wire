package com.saturne.redwire.resources;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.saturne.redwire.entities.Stagiaire;
import com.saturne.redwire.services.StagiaireService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/stagiaire")
public class StagiaireResource {

  private final StagiaireService sf;

  public StagiaireResource(StagiaireService sf) {
    this.sf = sf;
  }

  @GetMapping(name = "get.stagiaire")
  public ResponseEntity<Stagiaire> getStagiaire(@RequestHeader Map<String, String> headers) {
    String token = headers.get("authorization").toString();
    Map<String, Claim> response = this.getDataFromToken(token);
    String idsCh = response.get("idStagiaire").toString();
    idsCh = idsCh.substring(1, idsCh.length() - 1);
    Stagiaire stagiaire = sf.findStagiaireById(Long.parseLong(idsCh));
    System.out.println("Headers= " + headers);
    return new ResponseEntity<>(stagiaire, HttpStatus.ACCEPTED);
  }

  @PutMapping(name = "update.stagiaire")
  public ResponseEntity<Stagiaire> updateStagiaire(@RequestHeader Map<String, String> headers) {
    String token = headers.get("authorization").toString();
    Map<String, Claim> response = this.getDataFromToken(token);
    String idsCh = response.get("idStagiaire").toString();
    idsCh = idsCh.substring(1, idsCh.length() - 1);
    Stagiaire stagiaire = sf.findStagiaireById(Long.parseLong(idsCh));
    return new ResponseEntity<>(stagiaire, HttpStatus.OK);
  }

  private Map<String, Claim> getDataFromToken(String token) {
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
    return data;
  }
}
