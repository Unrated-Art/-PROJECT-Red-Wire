package com.saturne.redwire;

import com.saturne.redwire.entities.Catalogue;
import com.saturne.redwire.entities.Formation;
import com.saturne.redwire.entities.Session;
import com.saturne.redwire.services.CatalogueService;
import com.saturne.redwire.services.FormationService;
import com.saturne.redwire.services.SessionService;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class RedWireBackendApplication {

  @Autowired
  private FormationService formationService;

  private static final Logger log = LoggerFactory.getLogger(
    RedWireBackendApplication.class
  );

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
    return args -> {
      formationService.addFormation(
        new Formation(
          "ref",
          "intitulé",
          "lieu",
          true,
          6,
          "prerequis",
          "objectif",
          "String publicVise",
          "String programmeDetaille"
        )
      );
      formationService.addFormation(
        new Formation(
          "ref1",
          "intitulé1",
          "lieu1",
          true,
          8,
          "prerequis1",
          "objectif1",
          "String publicVise1",
          "String programmeDetaille1"
        )
      );
      formationService.addFormation(
        new Formation(
          "ref2",
          "intitulé",
          "lieu2",
          true,
          3,
          "prerequis2",
          "objectif2",
          "String publicVise2",
          "String programmeDetaille2"
        )
      );
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
    return args -> {
      catalogueService.addCatalogue(
        new Catalogue("title", "auteur1", "creationDate")
      );
      catalogueService.addCatalogue(
        new Catalogue("title2", "auteur2", "creationDate2")
      );
      catalogueService.addCatalogue(
        new Catalogue("title3", "auteur3", "creationDate3")
      );
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
  public CommandLineRunner demo2(SessionService sessionService) {
    return args -> {
      //Session(LocalDate dateDebut, LocalDate dateFin, String lieu, float prix)
      Session s = new Session(
        LocalDate.of(2022, 5, 20),
        LocalDate.of(2022, 5, 26),
        "Lyon",
        3000.0f
      );
      Session s1 = new Session(
        LocalDate.of(2022, 7, 12),
        LocalDate.of(2022, 8, 12),
        "Toulouse",
        3500.0f
      );
      Session s2 = new Session(
        LocalDate.of(2022, 3, 20),
        LocalDate.of(2022, 3, 23),
        "Lyon",
        6000.0f
      );
      sessionService.createSession(s);
      sessionService.createSession(s1);
      sessionService.createSession(s2);
      // fetch all sessions
      log.info("Catalogues found with findAllSessions():");
      log.info("-------------------------------");
      log.info(sessionService.getSession(1).toString());
      log.info(sessionService.getSession(2).toString());
      log.info(sessionService.getSession(3).toString());

      log.info("");
    };
  }

  /**
   * Cross-origin resource sharing
   * @return CorsFilter
   */
  @Bean
  public CorsFilter corsFilter() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.setAllowCredentials(true);
    corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
    corsConfiguration.setAllowedHeaders(
      Arrays.asList(
        "Origin",
        "Access-Control-Allow-Origin",
        "Content-Type",
        "Accept",
        "Authorization",
        "Origin, Accept",
        "X-Requested-With",
        "Access-Control-Request-Method",
        "Access-Control-Request-Headers"
      )
    );
    corsConfiguration.setExposedHeaders(
      Arrays.asList(
        "Origin",
        "Content-Type",
        "Accept",
        "Authorization",
        "Access-Control-Allow-Origin",
        "Access-Control-Allow-Origin",
        "Access-Control-Allow-Credentials"
      )
    );
    corsConfiguration.setAllowedMethods(
      Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")
    );
    UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
    urlBasedCorsConfigurationSource.registerCorsConfiguration(
      "/**",
      corsConfiguration
    );
    return new CorsFilter(urlBasedCorsConfigurationSource);
  }
}
