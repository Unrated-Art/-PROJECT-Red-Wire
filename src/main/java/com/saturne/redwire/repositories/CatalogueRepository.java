package com.saturne.redwire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saturne.redwire.entities.Catalogue;

public interface CatalogueRepository extends JpaRepository<Catalogue, Long> {
	
	
}
