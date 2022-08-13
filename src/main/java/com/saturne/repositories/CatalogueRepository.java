package com.saturne.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saturne.entities.Catalogue;

@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue, Long> {
	
	Optional<Catalogue> findCatalogueById (long id);
}
