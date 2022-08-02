package com.saturne.services;

import java.util.List;

import com.saturne.entities.Formation;

public interface IServiceCatalogue {
	
	public void addTraining(Formation f);
	
	public Formation getTraining(String reference);
	
	public List<Formation> getAllTrainings();
	
	public void deleteTraining(long idFormation);
}
