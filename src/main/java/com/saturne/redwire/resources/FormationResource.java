package com.saturne.redwire.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.saturne.redwire.entities.Formation;
import com.saturne.redwire.services.FormationService;
import java.util.List;

@RestController
@RequestMapping(path= "/api/training")
public class FormationResource {
	
	
	private final FormationService sf;

	public FormationResource(FormationService sf) {
		this.sf = sf;
	}
	
	
	 @GetMapping("/all")
	    public ResponseEntity<List<Formation>> getAllFormations () {
	        List<Formation> formations = sf.findAllFormations();
	        return new ResponseEntity<>(formations, HttpStatus.OK);
	    }

	    @GetMapping(name= "get.training", path= "findbyId/{id}")
	    public ResponseEntity<Formation> getFormationById (@PathVariable("id") long id) {
	        Formation Formation = sf.findFormationById(id);
	        return new ResponseEntity<>(Formation, HttpStatus.OK);
	    }
	    
	    // getFormationByReference & getFormationByKeyword => Tested OK :) 

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

	    @PostMapping(name = "create.training" ,path = "/add")//,
//	    		consumes = MediaType.APPLICATION_JSON_VALUE, 
//	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Formation> addFormation(
	    		@RequestParam(name = "reference") String reference,
	    		@RequestParam(name = "titref") String titref,
	    		@RequestParam(name = "lieu") String lieu,
	    		@RequestParam(name = "interFormation") boolean interFormation,
	    		@RequestParam(name = "duree") int duree,
	    		@RequestParam(name = "prerequis") String prerequis,
	    		@RequestParam(name = "objectif") String objectif,
	    		@RequestParam(name = "publicVise") String publicVise,
	    		@RequestParam(name = "programmeDetaille") String programmeDetaille)	      
	    {
	        Formation newf = new Formation();
	        newf.setReference(reference);
	        newf.setTitref(titref);
	        newf.setLieu(lieu);
	        newf.setInterFormation(interFormation);
	        newf.setDuree(duree);
	        newf.setPrerequis(prerequis);
	        newf.setObjectif(objectif);
	        newf.setPublicVise(publicVise);
	        newf.setProgrammeDetaille(programmeDetaille);
	        sf.addFormation(newf);
	        return new ResponseEntity<>(newf, HttpStatus.CREATED);
	    }
	    
/**	
 * addFormation : Consumes/produces JSON
 *     @PostMapping(path = "/addJSON", 
	            consumes = MediaType.APPLICATION_JSON_VALUE, 
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Formation> create(@RequestBody Formation newf) {
	    	Formation f = sf.addFormation(newf);
	        if (f != null) {
	        
	        	return null;
	            //throw new ServerException("Training not found");
	        } else {
	            return new ResponseEntity<>(f, HttpStatus.CREATED);
	        }
	    }
*/	    
	    
	    @PutMapping("/update/{id}")
	    public ResponseEntity<Formation> updateFormation(
	    		@PathVariable(name="id") long id,
	    		@RequestParam(name = "reference") String reference,
	    		@RequestParam(name = "titref") String titref,
	    		@RequestParam(name = "lieu") String lieu,
	    		@RequestParam(name = "interFormation") boolean interFormation,
	    		@RequestParam(name = "duree") int duree,
	    		@RequestParam(name = "prerequis") String prerequis,
	    		@RequestParam(name = "objectif") String objectif,
	    		@RequestParam(name = "publicVise") String publicVise,
	    		@RequestParam(name = "programmeDetaille") String programmeDetaille)	 {
	        Formation uf = sf.findFormationById(id);
	        if (uf != null) {
	        	if (reference != null)
	        	uf.setReference(reference);
	        	if (titref != null)
	        	uf.setTitref(titref);
	        	if (lieu!=null)
	        	uf.setLieu(lieu);
	     
	        	uf.setInterFormation(interFormation);
	        	if (duree!=0)
	        	uf.setDuree(duree);
	        	if (prerequis!=null)
	        	uf.setPrerequis(prerequis);
	        	if (objectif!=null)
	        	uf.setObjectif(objectif);
	        	if (publicVise!=null)
	        	uf.setPublicVise(publicVise);
	        	if (programmeDetaille!=null)
	        	uf.setProgrammeDetaille(programmeDetaille);
	        }
	            sf.updateFormation(uf);
	        return new ResponseEntity<>(uf, HttpStatus.OK);
	    }
	    
	    
	    

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteFormation(@PathVariable("id") long id) {
	        sf.deleteFormation(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	
}
