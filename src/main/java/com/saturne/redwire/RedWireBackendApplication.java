package com.saturne.redwire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.saturne.redwire.entities.Formation;
import com.saturne.redwire.repositories.FormationRepository;
import com.saturne.redwire.resources.FormationResource;
import com.saturne.redwire.services.FormationService;

@SpringBootApplication
public class RedWireBackendApplication {
	
	@Autowired 
	private FormationService formationService;
	
	
//	@Autowired
//	private FormationRepository repo;
	
	private static final Logger log = LoggerFactory.getLogger(RedWireBackendApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(RedWireBackendApplication.class, args);
		log.info("our server is listening in port 8080");
	}	
	
	
	/**
	 * Test with repository
	 * @param repo
	 * @return
	 */
//	@Bean
//	public CommandLineRunner demo(FormationRepository repo) {
//	return (args) -> {
//		
//		repo.save(new Formation("reference", "intitulé", "lieu", true, 6, "prerequis",
//			"objectif", "String publicVise", "String programmeDetaille"));
//		repo.save(new Formation("reference1",  "intitulé1","lieu1", true, 6, "prerequis1",
//		"objectif1", "String publicVise1", "String programmeDetaille1"));
//		repo.save(new Formation("reference2",  "intitulé","lieu2", true, 6, "prerequis2",
//			"objectif2", "String publicVise2", "String programmeDetaille2"));
//	// fetch all trainings
//	log.info("Trainings found with findAll():");
//	log.info("-------------------------------");
//	for (Formation f : repo.findAll()) {
//	log.info(f.toString());
//	}
//	log.info("");
//	
//	};
//	}
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

	
	
//	@Override
//	public void run(String... args) throws Exception {
//		repo.save(new Formation("reference", "intitulé" ,"lieu", true, 6, "prerequis",
//			"objectif", "publicVise", "programmeDetaille"));
//		repo.save(new Formation("reference2",  "intitulé","lieu2", true, 7, "prerequis2",
//				"objectif2", "publicVise2", "programmeDetaille2"));
//		log.info("****************************OK************************************************");
//	}

	
}
