package com.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
   /**
    * Singleton de l'EntityManagerFactory de l'application
    */
    private static EntityManagerFactory emf = null; 
 
    /**
     * Permet de récupérer l'EntityManagerFactory de
     * l'application tout en le créant s'il n'existe pas
     *
     * @return l'EntityManagerFactory unique de l'application
     */
    public static EntityManagerFactory getEmf() {
        if(emf == null){ 
            emf = Persistence.createEntityManagerFactory("projetFILROUGE"); 
        } 
        return emf; 
    } 
 
    /**
     * Libère les ressources et détruit l'EntityManagerFactory
     * si jamais il faut le recréer.
     */
    public static void close(){ 
    	if(emf!=null){ 
    		emf.close(); 
    		emf=null; 
        } 
    }
}
