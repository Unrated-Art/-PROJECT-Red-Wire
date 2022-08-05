package com.saturne.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saturne.entities.Formation;

public interface CatalogueRepository extends JpaRepository<Formation, Long> {
}
