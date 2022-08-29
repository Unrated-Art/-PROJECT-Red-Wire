package com.saturne.redwire;

import com.saturne.redwire.entities.Administrateur;
import com.saturne.redwire.entities.Catalogue;
import com.saturne.redwire.entities.Formation;
import com.saturne.redwire.entities.Session;
import com.saturne.redwire.entities.Stagiaire;
import com.saturne.redwire.entities.Theme;
import com.saturne.redwire.entities.User;
import com.saturne.redwire.enumerations.Role;
import com.saturne.redwire.services.CatalogueService;
import com.saturne.redwire.services.FormationService;
import com.saturne.redwire.services.SessionService;
import com.saturne.redwire.services.StagiaireService;
import com.saturne.redwire.services.ThemeService;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
    return args -> {
    	/*1*/
        formationService.addFormation(
                new Formation(
                 /*reference*/  "BD500",
                 /*titref*/ 	"Formation Big Data - Enjeux et perspectives",
                 /*lieu*/       "Paris",
                 /*interFormation*/true,
                  /*duree*/  2,
                  /*prerequis*/"Savoir manipuler un outil bureautique comme Excel et connaitre le fonctionnement d'un système de gestion de base de données (SGBD/R)",
                  /*objectif*/"Connaitre les informations essentielles pour lancer une initiative Big Data et comprendre comment les entreprises les plus avancées, dans tous les secteurs, ont tiré profit de projets Big Data",
                  /*publicVise*/"Toute personne amenée à participer à un projet Big Data (MOA, Chefs de projet, Développeurs, Analystes...)",
               /*programmeDetaille*/"LA DÉFINITION DU BIG DATA\r\n LES ORIGINES DU BIG DATA ET LES FACTEURS D'ÉVOLUTION DU BIG DATA\r\n"
               		+ " LE MARCHÉ BIG DATA ET LES PRINCIPAUX CAS D'USAGES D'ANALYTIQUES\r\n LE PROJET BIG DATA ET LES TECHNOLOGIES FONDAMENTALES DES SOLUTIONS"
               		
               		
                )
              );
    	/*2*/
      formationService.addFormation(
        new Formation(
          "OR100", //reference
          "Formation Interroger et manipuler des bases de données Oracle avec le langage SQL", //intitulé
          "Lyon", //lieu
          true, //interentreprise
          3, //duree
          "Avoir suivi la formation \"Introduction au SGBD Oracle\" (OR10) ou connaissances équivalentes", //prérequis
          "Apprendre à coder en Java", //objectif
          "Analystes et analystes programmeurs\r\nResponsables de service, chefs de projet\r\nAdministrateurs de bases de données, exploitants", //public visé
          "Chapitre1, chapitre2..etc" //programme détaillé
        )
      );
      
      /*3*/
      formationService.addFormation(
    	        new Formation(
    	          "OR100", //reference
    	          "Formation Interroger et manipuler des bases de données Oracle avec le langage SQL", //intitulé
    	          "Lyon", //lieu
    	          true, //interentreprise
    	          3, //duree
    	          "Avoir suivi la formation \"Introduction au SGBD Oracle\" (OR10) ou connaissances équivalentes", //prérequis
    	          "Apprendre à coder en Java", //objectif
    	          "-29ans", //public visé
    	          "Chapitre1, chapitre2..etc" //programme détaillé
    	        )
    	      );
      
      /*4*/
      formationService.addFormation(
    	        new Formation(
    	          "OR100", //reference
    	          "Formation Interroger et manipuler des bases de données Oracle avec le langage SQL", //intitulé
    	          "Lyon", //lieu
    	          true, //interentreprise
    	          3, //duree
    	          "Avoir suivi la formation \"Introduction au SGBD Oracle\" (OR10) ou connaissances équivalentes", //prérequis
    	          "Apprendre à coder en Java", //objectif
    	          "-29ans", //public visé
    	          "Chapitre1, chapitre2..etc" //programme détaillé
    	        )
    	      );
      
      /*5*/
      
      formationService.addFormation(
    	        new Formation(
    	          "OR100", //reference
    	          "Formation Interroger et manipuler des bases de données Oracle avec le langage SQL", //intitulé
    	          "Lyon", //lieu
    	          true, //interentreprise
    	          3, //duree
    	          "Avoir suivi la formation \"Introduction au SGBD Oracle\" (OR10) ou connaissances équivalentes", //prérequis
    	          "Apprendre à coder en Java", //objectif
    	          "-29ans", //public visé
    	          "Chapitre1, chapitre2..etc" //programme détaillé
    	        )
    	      );
      
      /*6*/
      formationService.addFormation(
    	        new Formation(
    	          "OR100", //reference
    	          "Formation Interroger et manipuler des bases de données Oracle avec le langage SQL", //intitulé
    	          "Lyon", //lieu
    	          true, //interentreprise
    	          3, //duree
    	          "Avoir suivi la formation \"Introduction au SGBD Oracle\" (OR10) ou connaissances équivalentes", //prérequis
    	          "Apprendre à coder en Java", //objectif
    	          "-29ans", //public visé
    	          "Chapitre1, chapitre2..etc" //programme détaillé
    	        )
    	      );
      /*7*/
      formationService.addFormation(
    	        new Formation(
    	          "OR100", //reference
    	          "Formation Interroger et manipuler des bases de données Oracle avec le langage SQL", //intitulé
    	          "Lyon", //lieu
    	          true, //interentreprise
    	          3, //duree
    	          "Avoir suivi la formation \"Introduction au SGBD Oracle\" (OR10) ou connaissances équivalentes", //prérequis
    	          "Apprendre à coder en Java", //objectif
    	          "-29ans", //public visé
    	          "Chapitre1, chapitre2..etc" //programme détaillé
    	        )
    	      );
      /*8*/
      formationService.addFormation(
    	        new Formation(
    	          "OR100", //reference
    	          "Formation Interroger et manipuler des bases de données Oracle avec le langage SQL", //intitulé
    	          "Lyon", //lieu
    	          true, //interentreprise
    	          3, //duree
    	          "Avoir suivi la formation \"Introduction au SGBD Oracle\" (OR10) ou connaissances équivalentes", //prérequis
    	          "Apprendre à coder en Java", //objectif
    	          "-29ans", //public visé
    	          "Chapitre1, chapitre2..etc" //programme détaillé
    	        )
    	      );
      /*9*/
      formationService.addFormation(
    	        new Formation(
    	          "OR100", //reference
    	          "Formation Interroger et manipuler des bases de données Oracle avec le langage SQL", //intitulé
    	          "Lyon", //lieu
    	          true, //interentreprise
    	          3, //duree
    	          "Avoir suivi la formation \"Introduction au SGBD Oracle\" (OR10) ou connaissances équivalentes", //prérequis
    	          "Apprendre à coder en Java", //objectif
    	          "-29ans", //public visé
    	          "Chapitre1, chapitre2..etc" //programme détaillé
    	        )
    	      );
      /*10*/
      formationService.addFormation(
    	        new Formation(
    	          "OR100", //reference
    	          "Formation Interroger et manipuler des bases de données Oracle avec le langage SQL", //intitulé
    	          "Lyon", //lieu
    	          true, //interentreprise
    	          3, //duree
    	          "Avoir suivi la formation \"Introduction au SGBD Oracle\" (OR10) ou connaissances équivalentes", //prérequis
    	          "Apprendre à coder en Java", //objectif
    	          "-29ans", //public visé
    	          "Chapitre1, chapitre2..etc" //programme détaillé
    	        )
    	      );
      /*11*/
      formationService.addFormation(
        new Formation(
          "OB301",
          "Java - accès aux données",
          "Toulouse",
          true,
          8,
          "aucun",
          "Comprendre la notion de classe/objet",
          "tout public",
          "Chapter3,chapter5"
        )
      );
      
      /*12*/
      formationService.addFormation(
        new Formation(
          "AB134",
          "Programmation web",
          "Lyon",
          true,
          3,
          "Aucun",
          "apprendre à faire des sites web en HTML/CSS/JS",
          "tout public",
          "Chapter6, Chapter4"
        )
      );
      
      
      /*13*/
      formationService.addFormation(
    	        new Formation(
    	          "CE980",
    	          "Javascript - Fondamentaux",
    	          "Toulouse",
    	          true,
    	          3,
    	          "Disposer de connaissances en langages HTML et CSS Connaître la programmation structurée",
    	          "Comprendre la notion de classe/objet",
    	          "Développeurs Web, Architectes Web, Chefs de projet,Webmasters…",
    	          "*JAVASCRIPT : LE COEUR DU LANGAGE\r\n La syntaxe, Les variables et les constantes, "
    	          + "Les fonctions globales, Les opérateurs, Les structures de contrôle, Les fonctions , fonctions sous forme de données\r\n "
    	          + "*LES OBJETS DU NAVIGATEUR: La hiérarchie des objets, Les principaux objets "
    	        )
    	      );
      
      /*14*/
//      formationService.addFormation(
//    	        new Formation(
//    	          "CE954",
//    	          "JavaScript - Programmation avancée",
//    	          "Rennes",
//    	          true,
//    	          3,
//    	          "Avoir des connaissances pratiques en JavaScript, HTML et CSS\r\n Posséder des connaissances de base de XML",
//    	          "Découvrir les concepts avancés JavaScript ES5 \r\n-Mettre en pratique la Programmation Orientée Objet
//    	    -Maîtriser l'environnement de débogage
//    	    -Mettre en oeuvre le framework JavaScript jQuery
//    	    -Manipuler les API JavaScript HTML5
//    	    -Appréhender la notion de JavaScript côté serveur avec Node.js
//    	",
//    	          "Développeurs Web, Architectes Web, Chefs de projet,Webmasters…”,
//    	    “-LE MOT-CLÉ “THIS
//    	     -LISTE D'ÉLÉMENTS : DES ALTERNATIVES AUX BOUCLES
//    	     -LES ARCHITECTURES PRÉ-ES2015
//    	     -LES PACKAGES ET LA TRANSPILATION
//    	     -TYPESCRIPT
//    	     -WEB APIS ET PWA
//    	     -TESTS
//    	     -INTRODUCTION AUX LIBRAIRIES / FRAMEWORKS FRONT-END
//    	     -BONUS : NODE.JS ET AUTRES WEB APIS“
//    	        )
//    	      );
      
      /*15*/
      /*
       formationService.addFormation(
        new Formation(
          "LI200",
          "Développement d'applications web",
          "Lyon",
          true,
          4,
          “-Maîtriser la syntaxe PHP en vue de développer de sites Web dynamiques
    -Apprendre à créer des applications dynamiques avec PHP et MySQL
    -Comprendre les bonnes pratiques de programmation PHP
    -Traiter des formulaires Web
    -Gérer des sessions utilisateurs",
          "Disposer de connaissances pratiques de HTML et au moins d'un langage de programmation",
          "Développeurs Web, Architectes Web, Chefs de projet,Webmasters…”,
    “- INTRODUCTION À LA PROGRAMMATION AVEC PHP
     - INSTALLATION DE PHP ET MYSQL
     - LES BASES DE PHP
     - LES FORMULAIRES ET L'INTERACTION UTILISATEURS
     - AUTHENTIFICATION, SESSIONS ET COOKIES
     - LES BASES DE DONNÉES (MYSQL)
     - COMMUNICATION ENTRE PHP ET MYSQL
     - TECHNIQUES AVANCÉES”
        )
      );
       */
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
      catalogueService.addCatalogue(new Catalogue("title", "auteur1", "creationDate"));
      catalogueService.addCatalogue(new Catalogue("title2", "auteur2", "creationDate2"));
      catalogueService.addCatalogue(new Catalogue("title3", "auteur3", "creationDate3"));
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
      Session s = new Session(LocalDate.of(2022, 5, 20), LocalDate.of(2022, 5, 26), "Lyon", 3000.0f);
      Session s1 = new Session(LocalDate.of(2022, 7, 12), LocalDate.of(2022, 8, 12), "Toulouse", 3500.0f);
      Session s2 = new Session(LocalDate.of(2022, 3, 20), LocalDate.of(2022, 3, 23), "Lyon", 6000.0f);
      sessionService.createSession(s);
      sessionService.createSession(s1);
      sessionService.createSession(s2);
      // fetch all sessions
      log.info("Catalogues found with findAllSessions():");
      log.info("-------------------------------");
      log.info(sessionService.getSession(1).toString());
      log.info(sessionService.getSession(2).toString());
      log.info(sessionService.getSession(3).toString());

      Formation f1 = formationService.findFormationById(1);
      Formation f2 = formationService.findFormationById(2);

      s.setFormation(f1);
      s1.setFormation(f2);
      s2.setFormation(f2);
      sessionService.saveAll(Arrays.asList(s, s1, s2));
      log.info("");
    };
  }

  @Bean
  public CommandLineRunner demo3(ThemeService themeService, FormationService formationService) {
    return args -> {
      themeService.addTheme(new Theme("Développement"));
      themeService.addTheme(new Theme("Big Data, Data Science et IA"));
      themeService.addTheme(new Theme("Informatique décicionnelle"));
      themeService.addTheme(new Theme("Bases de données"));
      themeService.addTheme(new Theme("Réseaux et Télécoms"));
      themeService.addTheme(new Theme("Cybersécurité"));
      themeService.addTheme(new Theme("Cloud computing"));
      themeService.addTheme(new Theme("Virtualisation"));
      themeService.addTheme(new Theme("Windows et System Center"));
      themeService.addTheme(new Theme("Linux, Unix, Mac"));
      themeService.addTheme(new Theme("Solutions collaboratives Microsoft"));
      themeService.addTheme(new Theme("IBM"));
      themeService.addTheme(new Theme("SAP"));
      themeService.addTheme(new Theme("Tests"));
      themeService.addTheme(new Theme("Développement web et mobilité"));
      themeService.addTheme(new Theme("IoT, Systèmes embarquées, Robotic Process Automation"));
      themeService.addTheme(new Theme("DevOps, industrialisation et gestion de production"));
      themeService.addTheme(new Theme("PAO, CAO, DAO, BIM"));
      // fetch all Themes
      log.info("Themes found with findAllThemes():");
      log.info("-------------------------------");
      log.info(themeService.findAllThemes().toString());

      Formation f1 = formationService.findFormationById(1);
      Formation f2 = formationService.findFormationById(2);

      Set<Theme> themes1 = Stream.of(themeService.findThemeById(1), themeService.findThemeById(3)).collect(Collectors.toSet());
      Set<Theme> themes2 = Stream
        .of(themeService.findThemeById(2), themeService.findThemeById(5), themeService.findThemeById(7))
        .collect(Collectors.toSet());
      f1.setThemes(themes1);
      f2.setThemes(themes2);

      //themeService.saveAll();
      log.info("Demo3-Themes OK");
    };
  }

  //add trainees

  @Bean
  public CommandLineRunner demo4(StagiaireService ss) {
    return args -> {
      User admin = ss.createStagiaire(
        new Stagiaire("Barbelette", "Charline", "paris20", "admin@saturne.com", "0606060606", "123", true, "Talismas")
      );
      admin.setRole(Role.ADMIN);
      //ss.updateStagiaire(admin);
      User user2 = ss.createStagiaire(
        new Stagiaire("Charles", "J-M", "Pantin", "j-m.charles.garcia@gmail.com", "0707070707", null, false, "")
      );
      
      

      // fetch all Trainees
      log.info("Themes found with findAllTrainees():");
      log.info("-------------------------------");
      log.info(ss.findAllStagiaires().toString());
      log.info("Demo04-Trainees OK");
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
    corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
    urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
    return new CorsFilter(urlBasedCorsConfigurationSource);
  }
}
