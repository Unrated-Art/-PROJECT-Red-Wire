package com.saturne.redwire.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saturne.redwire.entities.Formation;
import com.saturne.redwire.entities.Theme;
import com.saturne.redwire.services.ThemeService;

@RestController
@RequestMapping(path = "/api/themes")
public class ThemeResource {
	
	private final ThemeService ts;

	  public ThemeResource(ThemeService ts) {
	    this.ts = ts;
	  }

	  @GetMapping("/all")
	  public ResponseEntity<List<Theme>> getAllThemes() {
	    List<Theme> themes = ts.findAllThemes();
	    return new ResponseEntity<>(themes, HttpStatus.OK);
	  }
	  
	  @GetMapping(name = "get.theme", path = "findbyId/{id}")
	  public ResponseEntity<Theme> getThemeById(
	    @PathVariable("id") long id
	  ) {
		  Theme theme = ts.findThemeById(id);
	    return new ResponseEntity<>(theme, HttpStatus.OK);
	  }
	  
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<?> deleteTheme(@PathVariable("id") long id) {
	    ts.deleteTheme(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	  }

}
