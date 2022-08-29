package com.saturne.redwire.services;

import com.saturne.redwire.entities.Theme;
import com.saturne.redwire.exceptions.TrainingNotFoundException;
import com.saturne.redwire.repositories.ThemeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ThemeService {

  @Autowired
  private ThemeRepository themeRepo;

  /***
   * @param t
   * @return Theme
   */
  public Theme addTheme(Theme t) {
    return themeRepo.saveAndFlush(t);
  }

  /**
   *
   * @return List<Theme>
   */
  public List<Theme> findAllThemes() {
    return themeRepo.findAll();
  }

  /**
   * @param theme
   * @return Theme
   */
  public Theme updateTheme(Theme theme) {
    return themeRepo.save(theme);
  }

  /**
   * @param id
   * @return Theme
   */
  public Theme findThemeById(long id) {
    return themeRepo.findThemeByIdTheme(id).orElseThrow(() -> new TrainingNotFoundException("Theme by id " + id + " was not found"));
  }

  /***
   *
   * @param id
   */
  public void deleteTheme(long id) {
    themeRepo.deleteThemeByIdTheme(id);
  }
}
