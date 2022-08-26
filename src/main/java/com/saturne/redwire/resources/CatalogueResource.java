package com.saturne.redwire.resources;

import com.saturne.redwire.entities.Catalogue;
import com.saturne.redwire.entities.Formation;
import com.saturne.redwire.services.CatalogueService;

import java.time.LocalDate;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/catalogue")
public class CatalogueResource {

  private final CatalogueService catalogueService;

  public CatalogueResource(CatalogueService catalogueService) {
    this.catalogueService = catalogueService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<Catalogue>> getAllCatalogues() {
    List<Catalogue> catalogues = catalogueService.findAllCatalogues();
    return new ResponseEntity<>(catalogues, HttpStatus.OK);
  }

  @GetMapping("/find/{idCatalogue}")
  public ResponseEntity<Catalogue> getCatalogueById(
    @PathVariable("id") int idCatalogue
  ) {
    Catalogue catalogue = catalogueService.findCatalogueById(idCatalogue);
    return new ResponseEntity<>(catalogue, HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Catalogue> addCatalogue(@RequestBody Catalogue c) {
    Catalogue newCatalogue = catalogueService.addCatalogue(
      new Catalogue(c.getTitre(), c.getAuteur(), c.getDateCreation())
    );
    return new ResponseEntity<>(newCatalogue, HttpStatus.OK);
  }
  
  @PutMapping("/update/{idCatalogue}")
  public ResponseEntity<Catalogue> updateCatalogue(
	  @PathVariable("idCatalogue") int _idCatalogue,
	  @RequestBody Catalogue catalogue
  ) {
	  // Search for Catalogue by idCatalogue
	  // Then Save Edited Fields)
	  Catalogue updateCatalogue = catalogueService.updateCatalogue(catalogue);
      return new ResponseEntity<>(updateCatalogue, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{idCatalogue}")
  public ResponseEntity<?> deleteCatalogue(@PathVariable("idCatalogue") int idCatalogue) {
	  catalogueService.deleteCatalogue(idCatalogue);
      return new ResponseEntity<>(HttpStatus.OK);
  }
}
