package com.saturne.redwire.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saturne.redwire.entities.Formation;
import com.saturne.redwire.entities.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long> {

    Optional<Theme> findThemeByIdTheme(long idTheme);
    
    void deleteThemeByIdTheme(long idTheme);
}
