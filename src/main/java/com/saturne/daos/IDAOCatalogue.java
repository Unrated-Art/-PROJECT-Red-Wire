package com.saturne.daos;

import java.util.ArrayList;

import com.saturne.entities.Formation;

public interface IDAOCatalogue {
	
	
	//Ajouter formation
	/*public boolean addTraining(String reference, String lieu, Boolean interFormation, int duree, String prerequis,
	String objectif, String publicVise, String programmeDetaille);*/
	
	
	public boolean addTraining(Formation f);
	
	//supprimer formation
	public int deleteTraining(long id);
	
	//Rechercher formation by reference
	public Formation getTrainingByReference(String reference);
	
	//Rechercher formation by Keyword,theme
	
	public ArrayList<Formation> getTrainingByKeyword(String keyword);
	
	//rechercher toutes les formations du catalogue
	public ArrayList<Formation> getAllTrainings();
	
	
	//Modifier formation
	/*public void modifyTraining(String reference, String lieu, Boolean interFormation, int duree, String prerequis,
	String objectif, String publicVise, String programmeDetaille);*/

}
