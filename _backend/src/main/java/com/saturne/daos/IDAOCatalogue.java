package com.saturne.daos;

import com.saturne.entities.Formation;
import java.util.ArrayList;

public interface IDAOCatalogue {
  //Ajouter formation
  /*public boolean addTraining(String reference, String lieu, Boolean interFormation, int duree, String prerequis,
	String objectif, String publicVise, String programmeDetaille);*/

  //supprimer formation
  public int deleteTraining(long id);

  //Rechercher formation
  public Formation getTraining(String reference);

  //rechercher toutes les formations du catalogue
  public ArrayList<Formation> getAllTrainings();
  //Modifier formation
  /*public void modifyTraining(String reference, String lieu, Boolean interFormation, int duree, String prerequis,
	String objectif, String publicVise, String programmeDetaille);*/

}
