package com.saturne.redwire.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saturne.redwire.entities.Formation;
import com.saturne.redwire.repositories.FormationRepository;
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
//	        formations.add(
//	        		new Formation("ref-XX02",
//						            "Ref. JavaScript avancee",
//						            "Paris - Olympiade",
//						            true,
//						            4800,
//						            "Acquis Algorithmique + JavaScript basique",
//						            "Maitrise JavaScript",
//						            "Jeune Adultes (18-30ans)",
//						            "Lorem, ipsum. Blo-Blo-Blii Blo-Blo-Blo"));
//	        formations.add(
//	        		new Formation("ref-XYWZ",
//						            "Java debutant",
//						            "Lyon",
//						            true,
//						            4500,
//						            "Acquis Algorithmique + Java basique",
//						            "Maitrise java",
//						            "Jeune Adultes (18-45ans)",
//						            "Lorem, ipsum. Blo-Blo-Blii Blo-Blo-Blo"));
	        return new ResponseEntity<>(formations, HttpStatus.OK);
	    }

	    @GetMapping(name= "get.training", path= "findbyId/{id}")
	    public ResponseEntity<Formation> getFormationById (@PathVariable("id") long id) {
	        Formation Formation = sf.findFormationById(id);
	        return new ResponseEntity<>(Formation, HttpStatus.OK);
	    }
	    
	    //!# TODO: getFormationByReference & getFormationByKeyword

	    @GetMapping("/{ref}")
	    public ResponseEntity<Formation> getFormationByReference(@PathVariable("ref") String ref) {
	        Formation formation = sf.findFormationByReference(ref);
	        return new ResponseEntity<>(formation, HttpStatus.OK);
	    }
	    
//	    // !! verifier !!
//	    @GetMapping("/find/{keyword}")
//	    public ResponseEntity<List<Formation>> getFormationsByKeyword(@PathVariable("keyword") String keyword) {
//	        List<Formation> formations = sf.findByKeyword(keyword);
//	        return new ResponseEntity<>(formations, HttpStatus.OK);
//	    }


	    @PostMapping("/add")
	    public ResponseEntity<Formation> addFormation(@RequestBody Formation f) {
	        Formation newFormation = sf.addFormation(f);
	        return new ResponseEntity<>(newFormation, HttpStatus.CREATED);
	    }

	    @PutMapping("/update")
	    public ResponseEntity<Formation> updateFormation(@RequestBody Formation f) {
	        Formation updateFormation = sf.updateFormation(f);
	        return new ResponseEntity<>(updateFormation, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteFormation(@PathVariable("id") long id) {
	        sf.deleteFormation(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	
}
