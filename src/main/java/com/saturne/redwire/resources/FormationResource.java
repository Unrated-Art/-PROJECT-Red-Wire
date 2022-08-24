package com.saturne.redwire.resources;

import com.saturne.redwire.entities.Formation;
import com.saturne.redwire.entities.Theme;
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
import org.springframework.web.bind.annotation.RequestParam;
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
  
//  @GetMapping("/all/themes")
//  public ResponseEntity<List<Theme>> getAllThemes() {
//	  List<Formation> formations = sf.findAllFormations();
//	  for(int i=0; ; i++)
//    List<Theme> allThemes ;
//		  //allThemes= sf.findAllFormations().for;
//    return new ResponseEntity<>(allThemes, HttpStatus.OK);
//  }

  @GetMapping(name = "get.training", path = "findbyId/{id}")
  public ResponseEntity<Formation> getFormationById(
    @PathVariable("id") long id
  ) {
    Formation Formation = sf.findFormationById(id);
    return new ResponseEntity<>(Formation, HttpStatus.OK);
  }

  // getFormationByReference & getFormationByKeyword => Tested OK :)

  @GetMapping("/findRef/{ref}")
  public ResponseEntity<Formation> getFormationByReference(
    @PathVariable("ref") String ref
  ) {
    Formation formation = sf.findFormationByReference(ref);
    return new ResponseEntity<>(formation, HttpStatus.OK);
  }

  @GetMapping("/findKeyword/{keyword}")
  public ResponseEntity<List<Formation>> getFormationsByKeyword(
    @PathVariable("keyword") String keyword
  ) {
    List<Formation> formations = sf.findByKeyword(keyword);
    return new ResponseEntity<>(formations, HttpStatus.OK);
  }

  /***
   * 
   * @param newf
   * @return 
   */
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
  public ResponseEntity<Formation> updateFormation(@RequestBody Formation uf){
//    ,@PathVariable(name = "id") long id
//  ) {
//    Formation uf = sf.findFormationById(id);
//    f.
//    if (uf != null) {
//      if (f.getReference() != null) uf.setReference(f.getReference());
//      if (f.getTitref() != null) uf.setTitref(titref);
//      if (lieu != null) uf.setLieu(lieu);
//
//      uf.setInterFormation(interFormation);
//      if (duree != 0) uf.setDuree(duree);
//      if (prerequis != null) uf.setPrerequis(prerequis);
//      if (objectif != null) uf.setObjectif(objectif);
//      if (publicVise != null) uf.setPublicVise(publicVise);
//      if (programmeDetaille != null) uf.setProgrammeDetaille(programmeDetaille);
//    }
    sf.updateFormation(uf);
    return new ResponseEntity<>(uf, HttpStatus.OK);
  }
  

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteFormation(@PathVariable("id") long id) {
    sf.deleteFormation(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
