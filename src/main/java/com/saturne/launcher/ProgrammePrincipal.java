package com.saturne.launcher;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import com.saturne.entities.*;
import com.saturne.util.JpaUtil;

public class ProgrammePrincipal {

	private static Logger log = Logger.getLogger(ProgrammePrincipal.class);
	
	public static void main(String[] args) {
		

		
		System.out.println("hello");
		

		try {
	    EntityManager em=JpaUtil.getEmf().createEntityManager();

		// 2 : Ouverture transaction 
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		 /**
		  * Début modifications dans la BD
		  */
		Catalogue cat= new Catalogue(/*new Auteur(1, "Xavier", "Blanc")*/"Responsable Catalogue", "22/06/2022" );
		
		
		
		
		/**	Formation(String reference, String lieu, Boolean interFormation, int duree, String prerequis,
		String objectif, String publicVise, String programmeDetaille)*/
		Formation f_java = new Formation("OB101", LieuFormation.Paris_La_Defense.toString() , true, 10 ,
				"Programmation Orientée Objet", "Développer des applications web en java",
				"tout public", "Programme détaillé de la formation Java");
		
		log.trace("Formation: "+ f_java+" créée");
		
		cat.getFormations().add(f_java);

		
		Formation html_css= new Formation("IW208", LieuFormation.Bordeaux.toString(), true, 30, 
				"Algorithmique", "Créer des sites web dynamiques avec html5 et css3", 
				"-29 ans", "Programme détaillé de la formation HTML5/CSS3");
		
		log.trace("Formation: "+ html_css+" créée");
		
		
		cat.getFormations().add(html_css);
		
		
		
		
		Stagiaire s1= new Stagiaire("GORRAB", "Adam",  "Joinville Le Pont", "adam@gmail.com", "0678956479", false, "");
		log.trace("Stagiaire: "+s1+" créé");
		
		EvalSession  ev1= new EvalSession(7, 8, 6, 7, 8, 6, true);
		log.trace("Evaluation de session: "+s1+" créé");
		
		ev1.setTrainee(s1);
		log.trace("Evaluation de session `ev1` liée au stagiaire `s1`");
		
		
		
		// Persistance Objet/Relationnel : création d'un enregistrement en base

		em.persist(cat);
		log.trace("`cat` persisted in Database 'Saturnefilrouge'");
		
		
//		em.persist(f_java); // => pas besoin de persister les formations (cascadeType.ALL dans catalogue)!!
//		log.trace("`f_java` persisted in Database 'Saturnefilrouge'");
//		em.persist(html_css);
//		log.trace("`html_css` persisted in Database 'Saturnefilrouge'");
		
		em.persist(s1);
		log.trace("`s1` persisted in Database 'Saturnefilrouge'");
		em.persist(ev1);
		log.trace("`ev1` persisted in Database 'Saturnefilrouge'");
		
		
		cat.setAuteur("MR.Bean"); //modification de l'objet `cat` persisté dans la base
		
		tx.commit();
		
		 /**
		  * Fin modifications dans la BD
		  */
		 
		// 6 : Fermeture de l'EntityManager et de unit� de travail JPA 
		em.close();
		
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		finally {
			// 7: Attention important, cette action ne doit s'executer qu'une seule fois et non pas à chaque instantiation du ContactDAO
			//Donc, pense bien à ce qu'elle soit la dernière action de votre application
			JpaUtil.close();
		}
		
		
		
		
		
		
		
		
		
	}

}
