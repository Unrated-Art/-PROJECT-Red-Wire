package com.saturne.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saturne.daos.IDAOCatalogue;
import com.saturne.entities.Formation;


/**
* 
* @author NBS
* 
* @done : Injection de dépendances w/ Spring core 
* @since   01-08-2022
*/

@Service("serviceCatalogue")
public class ServiceCatalogue implements IServiceCatalogue{

	private static Logger log = Logger.getLogger(ServiceCatalogue.class);
	public ServiceCatalogue() {
	
}
	
	@Autowired 
	IDAOCatalogue idao; //injected DAO W/ Spring

	
	/**
	 * ajouter une formation
	 * @return Nothing
	 */
	@Override
	public void addTraining(Formation f) {
		
		//DAOCatalogue dc = new DAOCatalogue(); 
		try
		{
			idao.addTraining(f);
			log.trace("La formation "+f.getReference()+" a été ajoutée");
		}
		catch (Error e)
		{
			e.printStackTrace();
		}
			
	}
	
	/**
	 * Rechercher une formation et l'afficher
	 * @param reference
	 * @return une formation
	 */
	@Override
	public Formation getTraining(String reference) { 
		//DAOCatalogue dc= new DAOCatalogue();
		
		Formation f = idao.getTrainingByReference(reference);
		/*String reference, String lieu, Boolean interFormation, int duree, String prerequis,
		String objectif, String publicVise, String programmeDetaille*/
		System.out.println("id= "+ f.getIdFormation() +", lieu= "+f.getLieu()+", interformation="+f.getInterFormation()+" ,durée="
							+ f.getDuree() +" ,prérequis="+ f.getPrerequis() + ", objectif=" + f.getObjectif()
							+ ", public visé="+ f.getPublicVise() +" ,programme détaillé="+ f.getProgrammeDetaille());
		return f;
		
	}
	
	/**
	 *  Rechercher toutes les formations
	 * @return all the trainings in DB
	 */
	@Override
	public List<Formation> getAllTrainings() { 
		
		
		//DAOCatalogue dc= new DAOCatalogue();
		
		
		List<Formation> formations = idao.getAllTrainings();
//		System.out.println("id= "+ f.getIdFormation() +", lieu= "+f.getLieu()+", interformation="+f.getInterFormation()+" ,durée="
//							+ f.getDuree() +" ,prérequis="+ f.getPrerequis() + ", objectif=" + f.getObjectif()
//							+ ", public visé="+ f.getPublicVise() +" ,programme détaillé="+ f.getProgrammeDetaille());
		
		return formations;
	}
	
	

	/**
	 * Supprimer une formation 
	 * @param idFormation
	 */
	@Override
	public void deleteTraining(long idFormation) { 
		//DAOCatalogue dc= new DAOCatalogue();
		int res = idao.deleteTraining(idFormation);
		if (res == 1) {
			System.out.println("La formation ayant comme id: "+idFormation+" a été supprimée");
		}
	
	}
	


	

}
