package com.saturne.redwire.services;

import com.saturne.redwire.entities.Formation;
import com.saturne.redwire.entities.Theme;
import com.saturne.redwire.exceptions.TrainingNotFoundException;
import com.saturne.redwire.repositories.FormationRepository;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FormationService {

  //injection de dépendance
  @Autowired
  private FormationRepository formationRepo;

  /**
   * @param formation
   * @return
   */
  public Formation addFormation(Formation f) {
    //        if (f.getTitref().toLowerCase().contains("java")) {
    //            f.getThemes().add(new Theme("Java"));
    ////            f.getThemes().add(new Theme("POO"));
    //        } else if (f.getTitref().toLowerCase().contains("web")) {
    //            f.getThemes().add(new Theme("Web"));
    //        } else {
    //            f.getThemes().add(new Theme("UNDEFINED"));
    //        }
    return formationRepo.saveAndFlush(f);
  }

  /**
   *
   * @return List<Formation>
   */
  public List<Formation> findAllFormations() {
    return formationRepo.findAll();
  }

  /**
   * @param formation
   * @return Formation
   */
  public Formation updateFormation(Formation formation) {
    return formationRepo.save(formation);
  }

  /**
   * @param id
   * @return Formation
   */
  public Formation findFormationById(long id) {
    return formationRepo
      .findFormationByIdFormation(id)
      .orElseThrow(() -> new TrainingNotFoundException("Training by id " + id + " was not found"));
  }

  /**
   *
   * @param keyword
   * @return List<Formation> containing 'keyword'
   */
  public List<Formation> findByKeyword(String keyword) {
    return formationRepo
      .findAll()
      .stream()
      .filter(f ->
        ((f.getReference()).toUpperCase()).contains(keyword.toUpperCase()) ||
        ((f.getTitref()).toUpperCase()).contains(keyword.toUpperCase()) ||
        ((f.getLieu()).toUpperCase()).contains(keyword.toUpperCase()) ||
        ((f.getObjectif()).toUpperCase()).contains(keyword.toUpperCase()) ||
        ((f.getPrerequis()).toUpperCase()).contains(keyword.toUpperCase()) ||
        ((f.getProgrammeDetaille()).toUpperCase()).contains(keyword.toUpperCase()) ||
        ((f.getPublicVise()).toUpperCase()).contains(keyword.toUpperCase())
      )
      /*|| ((f.getThemes().foreach()????.contains(keyword.toLowerCase())*/
      .collect(Collectors.toList());
    //.orElseThrow(() -> new TrainingNotFoundException("Training by keyword " + keyword + "was not found"));
  }

  /***
   * @param ref
   * @return Formation
   */
  public Formation findFormationByReference(String ref) {
    return formationRepo
      .findFormationByReference(ref)
      .orElseThrow(() -> new TrainingNotFoundException("Training by reference " + ref + "was not found"));
  }

  public void deleteFormation(long id) {
    formationRepo.deleteFormationByIdFormation(id);
  }
}
