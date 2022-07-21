package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import entities.*;
import util.JpaUtil;

public class Lanceur {

	private static Logger log = Logger.getLogger(Lanceur.class);
	
	public static void main(String[] args) {
		

		
		//boolean success=false;

		try {
	    EntityManager em=JpaUtil.getEmf().createEntityManager();

		// 2 : Ouverture transaction 
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		 /**
		  * Début modifications dans la BD
		  */
		Catalogue cat= new Catalogue(2022,/*new Auteur(1, "Xavier", "Blanc")*/"Responsable Catalogue", "22/06/2022" );
		
		/**	Formation(String reference, String lieu, Boolean interFormation, int duree, String prerequis,
		String objectif, String publicVise, String programmeDetaille)*/
//		Formation f_java = new Formation("OB101", LieuFormation.Paris_La_Defense.toString() , true, 10 ,
//				"Programmation Orientée Objet", "Développer des applications web en java",
//				"tout public", "Programme détaillé de la formation Java");
//		
//		log.trace("Formation: "+ f_java+" créée");

		
		/**Formation html_css= new Formation("IW208", LieuFormation.Bordeaux.toString(), true, 30, 
				"Algorithmique", "Créer des sites web dynamiques avec html5 et css3", 
				"-29 ans", "Programme détaillé de la formation HTML5/CSS3");
		
		log.trace("Formation: "+ html_css+" créée");
		*/
		
		//Stagiaire s1= new Stagiaire("GORRAB", "Adam",  "Joinville Le Pont", "adam@gmail.com", "0678956479", false, "");
		//log.trace("Stagiaire: "+s1+" créé");
		
		//EvalSession  ev1= new EvalSession(7, 8, 6, 7, 8, 6, true);
		//log.trace("Evaluation de session: "+s1+" créé");
		
		//ev1.setTrainee(s1);
		//log.trace("Evaluation de session `ev1` liée au stagiaire `s1`");
		
		
		
		// Persistance Objet/Relationnel : création d'un enregistrement en base
		 
		
		//em.persist(f_java);
//		log.trace("`f_java` persisted in Database 'Saturne'");
//		em.persist(html_css);
		log.trace("`html_css` persisted in Database 'Saturne'");
		//em.persist(s1);
		//log.trace("`s1` persisted in Database 'Saturne'");
		//em.persist(ev1);
		//log.trace("`ev1` persisted in Database 'Saturne'");
		
		tx.commit();
		
		 /**
		  * Fin modifications dans la BD
		  */
		 
		// 6 : Fermeture de l'EntityManager et de unit� de travail JPA 
		em.close();
		
		// 7: Attention important, cette action ne doit s'executer qu'une seule fois et non pas à chaque instantiation du ContactDAO
		//Donc, pense bien à ce qu'elle soit la dernière action de votre application
		//JpaUtil.close();	
		
		//success=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		//return success;
		
		
		
		
		
		
		
		
	}

}
