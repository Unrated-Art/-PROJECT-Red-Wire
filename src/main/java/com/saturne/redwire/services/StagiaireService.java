package com.saturne.redwire.services;

import com.saturne.redwire.entities.Stagiaire;
import com.saturne.redwire.exceptions.StagiaireNotFoundException;
import com.saturne.redwire.repositories.StagiaireRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StagiaireService {

  @Autowired
  private StagiaireRepository stagiaireRepo;

  /***
   * Ajouter stagiaire
   * @param stagiaire
   * @return stagiaire
   */
  public Stagiaire createStagiaire(Stagiaire s) {
    return stagiaireRepo.saveAndFlush(s);
  }

  /***
   * Editer stagiaire
   * @param stagiaire
   * @return stagiaire
   */
  public Stagiaire updateStagiaire(Stagiaire s) {
    return stagiaireRepo.saveAndFlush(s);
  }

  /**
   * getAllTrainees
   * @return List<Stagiaire>
   */
  public List<Stagiaire> findAllStagiaires() {
    return stagiaireRepo.findAll();
  }

  /**
   * Find trainee by Id
   * @param id
   * @return
   */
  public Stagiaire findStagiaireById(long id) {
    return stagiaireRepo
      .findStagiaireByIdStagiaire(id)
      .orElseThrow(() -> new StagiaireNotFoundException("Trainee by id " + id + " was not found"));
  }

  public Stagiaire findStagiaireByEmail(String email) {
    return stagiaireRepo.findStagiaireByEmail(email);
  }

  /**
   * DeleteStagiaire
   * @param id
   */
  public void deleteStagiaireById(long id) {
    stagiaireRepo.deleteStagiaireByIdStagiaire(id);
  }
}
