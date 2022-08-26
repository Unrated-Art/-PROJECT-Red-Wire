package com.saturne.redwire.repositories;

import com.saturne.redwire.entities.Theme;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
  Optional<Theme> findThemeByIdTheme(long idTheme);

  void deleteThemeByIdTheme(long idTheme);
}
