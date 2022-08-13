package com.saturne.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saturne.entities.Catalogue;
import com.saturne.services.CatalogueService;

@RestController
@RequestMapping("/catalogue")
public class CatalogueResource {
	private final CatalogueService serviceCatalogue;
	
	public CatalogueResource(CatalogueService serviceCatalogue) {
		this.serviceCatalogue = serviceCatalogue;
	}
	
	@GetMapping("/allcatalogue")
	public ResponseEntity<List<Catalogue>> getAllCatalogues () {
		List<Catalogue> catalogues = serviceCatalogue.findAllCatalogues();
		return new ResponseEntity<>(catalogues, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Catalogue> getCatalogueById (@PathVariable("id") Long id) {
		Catalogue catalogue = serviceCatalogue.findCatalogueById(id);
		return new ResponseEntity<>(catalogue, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Catalogue> addCatalogue(@RequestBody Catalogue catalogue) {
		Catalogue newCatalogue = serviceCatalogue.addCatalogue(catalogue);
		return new ResponseEntity<>(newCatalogue, HttpStatus.OK);
	}
	
}
