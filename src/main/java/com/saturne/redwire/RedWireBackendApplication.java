package com.saturne.redwire;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import com.saturne.redwire.entities.Catalogue;
import com.saturne.redwire.entities.Formation;
import com.saturne.redwire.services.CatalogueService;


import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


import com.saturne.redwire.services.FormationService;

@SpringBootApplication
public class RedWireBackendApplication {
	
	@Autowired 

	private FormationService formationService;
	
	
	private static final Logger log = LoggerFactory.getLogger(RedWireBackendApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(RedWireBackendApplication.class, args);
		log.info("our server is listening in port 8080");
	}	
	
	
	
/***
 * Test with FormationService
 * @param repo
 * @return
 */

	@Bean
	public CommandLineRunner demo(FormationService formationService) {
	return (args) -> {
		
		formationService.addFormation(new Formation("ref",  "intitulé","lieu", true, 6, "prerequis",
		"objectif", "String publicVise", "String programmeDetaille"));
		formationService.addFormation(new Formation("ref1",  "intitulé1","lieu1", true, 8, "prerequis1",
		"objectif1", "String publicVise1", "String programmeDetaille1"));
		formationService.addFormation(new Formation("ref2",  "intitulé","lieu2", true, 3, "prerequis2",
			"objectif2", "String publicVise2", "String programmeDetaille2"));
	// fetch all trainings
	log.info("Trainings found with findAllFormations():");
	log.info("-------------------------------");
	for (Formation f : formationService.findAllFormations()) {
	log.info(f.toString());
	}
	log.info("");
	
	};
	}
	
	@Bean
	public CommandLineRunner demo1(CatalogueService catalogueService) {
	return (args) -> {
		
		catalogueService.addCatalogue(new Catalogue("title", "creationDate"));
		catalogueService.addCatalogue(new Catalogue("title2", "creationDate2"));
		catalogueService.addCatalogue(new Catalogue("title3", "creationDate3"));
	// fetch all catalogues
	log.info("Catalogues found with findAllCatalogues():");
	log.info("-------------------------------");
	for (Catalogue catalogue : catalogueService.findAllCatalogues()) {
	log.info(catalogue.toString());
	}
	log.info("");
	
	};
	}


	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
