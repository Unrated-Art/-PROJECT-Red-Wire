package com.saturne.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.saturne.entities.Formation;
import com.saturne.launcher.ProgrammePrincipal;
import com.saturne.util.JpaUtil;

@Repository("idao")
public class DAOCatalogue implements IDAOCatalogue{

	private static Logger log = Logger.getLogger(ProgrammePrincipal.class);

	

	@Override
	public boolean addTraining(Formation f) {
		boolean success=false;
				
				try {
					EntityManager em=JpaUtil.getEmf().createEntityManager();
				
					EntityTransaction tx =  em.getTransaction();
					tx.begin();
						
					em.persist(f);
					 
					tx.commit();
						 	
					em.close();
				
					success=true;
					}
				catch (Exception e) 
					{
					e.printStackTrace();
					}
				return success;
	}
	
	
	@Override
	public Formation getTrainingByReference(String reference) { //rechercher une formation
		
			
			EntityManager em=JpaUtil.getEmf().createEntityManager();

			Formation f=new Formation();
			try { //.toString() => remove??
			    f = (Formation) em.createNamedQuery("Formation.FindTrainingByReference").setParameter(1, reference.toString()).getSingleResult();
			    log.trace("NamedNativeQuery: "+f+", reference: "+f.getReference()+" ,duree"+f.getDuree()+"blablabla.....");
			} catch (Exception e) {
			    log.debug("No result found for... ");
			    e.printStackTrace();
			}
			finally {
				em.close();	
			}
			
			return(f);
			

	}
	
	
	@Override
	public int deleteTraining(long id) {
		int success = 0;
		try {
			
			EntityManager em = JpaUtil.getEmf().createEntityManager();
			em.getTransaction().begin();
			
			Formation f = em.find(Formation.class, id);
			em.remove(f);
			
			em.getTransaction().commit();
			em.close();
			System.out.println(f+ "supprimée!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}


	@Override
	public ArrayList<Formation> getAllTrainings() {
		
        EntityManager em = JpaUtil.getEmf().createEntityManager(); 
        //"SELECT idTraining, ref, location, interTraining, duration,requirements, goal, targetAudience, details FROM Trainings"
        final String nativeQueryAllTrainings = "SELECT * FROM Trainings";
		ArrayList<Formation> allTrainings = new ArrayList<Formation>();
		
		em.getTransaction().begin();
		
		
		allTrainings = (ArrayList<Formation>) em.createNativeQuery(nativeQueryAllTrainings, Formation.class).getResultList();

		//#!TODO: To be continued avec getResultList

		
		for(Formation f:allTrainings) {
			log.info("Les informations de la formation: "+f.toString());
		}
		
		em.getTransaction().commit();
		em.close();

		return allTrainings;
			
		}


	@Override
	public ArrayList<Formation> getTrainingByKeyword(String keyword) {
		 	DAOCatalogue dc = new DAOCatalogue();
	        List<Formation> allTrainings = dc.getAllTrainings();
	        List<Formation> result = allTrainings.stream()
	        		.filter(f -> ((f.getReference()).toUpperCase()).contains(keyword.toLowerCase())
	        				|| ((f.getLieu()).toUpperCase()).contains(keyword.toLowerCase()) 
	        				|| ((f.getObjectif()).toUpperCase()).contains(keyword.toLowerCase()) 
	        				|| ((f.getPrerequis()).toUpperCase()).contains(keyword.toLowerCase()) 
	        				|| ((f.getProgrammeDetaille()).toUpperCase()).contains(keyword.toLowerCase()) 
	        				|| ((f.getPublicVise()).toUpperCase()).contains(keyword.toLowerCase()))
	        				/*|| ((f.getThemes().foreach()????.contains(keyword.toLowerCase())*/ 
	        				.collect(Collectors.toList());
	        		
	        log.info("Nombre de formation trouvé avec le mot clé " + keyword + " : " + result.size());
	        return (ArrayList<Formation>) result;
	        
	}




}
