package com.saturne.redwire.repositories;

import com.saturne.redwire.entities.Stagiaire;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {
  Optional<Stagiaire> findStagiaireByIdStagiaire(long idStagiaire);

  Stagiaire findStagiaireByEmail(String email);

  void deleteStagiaireByIdStagiaire(long idStagiaire);
}
