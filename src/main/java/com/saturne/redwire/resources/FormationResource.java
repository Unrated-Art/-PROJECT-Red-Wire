package com.saturne.redwire.resources;

import com.saturne.redwire.entities.Formation;
import com.saturne.redwire.services.FormationService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/training")
public class FormationResource {

  private final FormationService sf;

  public FormationResource(FormationService sf) {
    this.sf = sf;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Formation>> getAllFormations() {
    List<Formation> formations = sf.findAllFormations();
    return new ResponseEntity<>(formations, HttpStatus.OK);
  }

  @GetMapping(name = "get.training", path = "findbyId/{id}")
  public ResponseEntity<Formation> getFormationById(@PathVariable("id") long id) {
    Formation Formation = sf.findFormationById(id);
    return new ResponseEntity<>(Formation, HttpStatus.OK);
  }

  @GetMapping("/findRef/{ref}")
  public ResponseEntity<Formation> getFormationByReference(@PathVariable("ref") String ref) {
    Formation formation = sf.findFormationByReference(ref);
    return new ResponseEntity<>(formation, HttpStatus.OK);
  }

  @GetMapping("/findKeyword/{keyword}")
  public ResponseEntity<List<Formation>> getFormationsByKeyword(@PathVariable("keyword") String keyword) {
    List<Formation> formations = sf.findByKeyword(keyword);
    return new ResponseEntity<>(formations, HttpStatus.OK);
  }

  @PostMapping(
	      path = "/add",
	      name = "create.training",
	      consumes = MediaType.APPLICATION_JSON_VALUE
	  )
	  @ResponseStatus(HttpStatus.CREATED)
	  public Formation addFormation(@RequestBody Formation newf){
	      try {
	          sf.addFormation(newf);  
	      }
	      catch(Exception ex) {
	        System.out.println(ex.getMessage());
	        return null;
	      }
	      return newf;
	  }

  @PutMapping("/update/{id}")
  public ResponseEntity<Formation> updateFormation(@PathVariable("id") long id, @RequestBody Formation uf) {
    Formation f = sf.findFormationById(id);
    if (f != null) {
      if (!uf.getReference().isEmpty()) {
        f.setReference(uf.getReference());
      }
      if (!uf.getTitref().isEmpty()) {
        f.setTitref(uf.getTitref());
      }
      if (!uf.getLieu().isEmpty()) {
        f.setLieu(uf.getLieu());
      }
      if (uf.getInterFormation() != f.getInterFormation()) {
        f.setInterFormation(uf.getInterFormation());
      }
      if (uf.getDuree() > 0) {
        f.setDuree(uf.getDuree());
      }
      if (!uf.getPrerequis().isEmpty()) {
        f.setPrerequis(uf.getPrerequis());
      }
      if (!uf.getObjectif().isEmpty()) {
        f.setObjectif(uf.getObjectif());
      }
      if (!uf.getPublicVise().isEmpty()) {
        f.setPublicVise(uf.getPublicVise());
      }
      if (!uf.getProgrammeDetaille().isEmpty()) {
        f.setProgrammeDetaille(uf.getProgrammeDetaille());
      }
      if (!uf.getThemes().isEmpty()) {
        f.setThemes(uf.getThemes());
      }
      if (!uf.getSessions().isEmpty()) { //#TODO: vérif condition
        f.setSessions(uf.getSessions());
      }
      if (uf.getPretest() != null) { //#TODO: vérif condition
        f.setPretest(uf.getPretest());
      }
      if (!uf.getChapitres().isEmpty()) { //#TODO: vérif condition
        f.setChapitres(uf.getChapitres());
      }
      sf.updateFormation(f);
    }
    return new ResponseEntity<>(f, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteFormation(@PathVariable("id") long id) {
    sf.deleteFormation(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
