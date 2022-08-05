package com.saturne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saturne.entities.Catalogue;


public interface CatalogueRepository extends JpaRepository<Catalogue, Long> {
}
