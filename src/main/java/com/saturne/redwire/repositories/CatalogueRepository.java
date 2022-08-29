package com.saturne.redwire.repositories;

import com.saturne.redwire.entities.Catalogue;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {
	void deleteCatalogueByIdCatalogue(int idCatalogue);
  Optional<Catalogue> findCatalogueByIdCatalogue(int idCatalogue);
}
