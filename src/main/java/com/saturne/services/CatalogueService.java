package com.saturne.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saturne.entities.Catalogue;
import com.saturne.redwire.exceptions.CatalogueNotFoundException;
import com.saturne.repositories.CatalogueRepository;

@Service
@Transactional
public class CatalogueService {
	private final CatalogueRepository catalogueRepository;
	
//Injection de dépendance 
	@Autowired
	public CatalogueService(CatalogueRepository catalogueRepository) {
		this.catalogueRepository = catalogueRepository;
}
//Ajouter un catalogue
	public Catalogue addCatalogue(Catalogue catalogue) {
		
		
		//catalogue.setCatalogueCode(UUID.randomUUID().toString());
		return catalogueRepository.save(catalogue) ;
	}
	
//Rechercher tous les catalogues et les afficher @param reference
	public List<Catalogue> findAllCatalogues() {
		return catalogueRepository.findAll();
	}
	
//Rechercher un catalogue et l'afficher @param reference
	
	public Catalogue findCatalogueById(long id) {
        return catalogueRepository.findCatalogueById(id)
        		.orElseThrow(() -> new CatalogueNotFoundException("Catalogue by id " + id + "was not found"));
    }
	
//Supprimer une formation @param idFormation
	
	

}
