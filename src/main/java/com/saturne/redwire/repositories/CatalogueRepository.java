package com.saturne.redwire.repositories;

import com.saturne.redwire.entities.Catalogue;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {
  Optional<Catalogue> findCatalogueByIdCatalogue(int id);
}
