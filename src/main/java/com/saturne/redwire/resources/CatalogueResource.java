package com.saturne.redwire.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saturne.redwire.entities.Catalogue;
import com.saturne.redwire.entities.Formation;
import com.saturne.redwire.services.CatalogueService;

@RestController
@RequestMapping(path = "/api/catalogue")
public class CatalogueResource {
	private final CatalogueService serviceCatalogue;
	
	public CatalogueResource(CatalogueService serviceCatalogue) {
		this.serviceCatalogue = serviceCatalogue;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Catalogue>> getAllCatalogues() {
		List<Catalogue> catalogues = serviceCatalogue.findAllCatalogues();
		return new ResponseEntity<>(catalogues, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Catalogue> getCatalogueById(@PathVariable("id") int id) {
		Catalogue catalogue = serviceCatalogue.findCatalogueById(id);
		return new ResponseEntity<>(catalogue, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Catalogue> addCatalogue(
			@RequestParam(name = "titre") String titre,
			@RequestParam(name = "auteur") String auteur,
			@RequestParam(name = "dateCreation") String dateCreation
			) {
		Catalogue newCatalogue = serviceCatalogue.addCatalogue(
				new Catalogue(titre,auteur,dateCreation));
		return new ResponseEntity<>(newCatalogue, HttpStatus.OK);
	}
	
}
