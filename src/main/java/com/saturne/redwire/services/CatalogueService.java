package com.saturne.redwire.services;

import com.saturne.redwire.entities.Catalogue;
import com.saturne.redwire.exceptions.CatalogueNotFoundException;
import com.saturne.redwire.repositories.CatalogueRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CatalogueService {

  //Injection de dépendance
  @Autowired
  private CatalogueRepository catalogueRepository;

  //Ajouter un catalogue
  public Catalogue addCatalogue(Catalogue catalogue) {
    //catalogue.setCatalogueCode(UUID.randomUUID().toString());
    return catalogueRepository.save(catalogue);
  }

  //Rechercher tous les catalogues et les afficher @param reference
  public List<Catalogue> findAllCatalogues() {
    return catalogueRepository.findAll();
  }

  //Rechercher un catalogue et l'afficher @param reference

  public Catalogue findCatalogueById(int id) {
    return catalogueRepository
      .findCatalogueByIdCatalogue(id)
      .orElseThrow(() ->
        new CatalogueNotFoundException(
          "Catalogue by id " + id + "was not found"
        )
      );
  }
  //Supprimer une formation @param idFormation

}
