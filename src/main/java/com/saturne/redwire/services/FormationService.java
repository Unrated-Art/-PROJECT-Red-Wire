package com.saturne.redwire.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saturne.redwire.entities.Formation;
import com.saturne.redwire.exceptions.TrainingNotFoundException;
import com.saturne.redwire.repositories.FormationRepository;


@Service
@Transactional
public class FormationService {
	
	//injection de dépendance
	@Autowired
	private FormationRepository formationRepo;



	/**
	 * @param formation
	 * @return
	 */
	public Formation addFormation(Formation f) {
//		f.setTitref("Java");
//		f.setReference("AB1020");
//		f.setDuree(5);
//		f.setLieu("Lyon");
//		f.setInterFormation(true);
//		f.setObjectif("obj");
//		f.setPrerequis("nothing");
//		f.setProgrammeDetaille("detailsFrom");
//		f.setPublicVise("all");
//		System.out.println("f persisted in DB!!!!!!");
        return formationRepo.save(f);
        
    }

	/**
	 * 
	 * @return List<Formation>
	 */
    public List<Formation> findAllFormations() {
        return formationRepo.findAll();
    }

    /**
     * @param formation
     * @return Formation
     */
    public Formation updateFormation(Formation formation) {
        return formationRepo.save(formation);
    }

    /**
     * @param id
     * @return Formation
     */
    public Formation findFormationById(long id) {
        return formationRepo.findFormationByIdFormation(id)
                .orElseThrow(() -> new TrainingNotFoundException("Training by id " + id + " was not found"));
    }
    
//    //#! TODO: implement method with stream/filter!!!!
//	public List<Formation> findByKeyword(String keyword) {
//			
//		return formationRepo.findByKeyword(keyword);
//				//.orElseThrow(() -> new TrainingNotFoundException("Training by keyword " + keyword + "was not found"));
//		
//	}
	
	
	public Formation findFormationByReference(String ref){
		return formationRepo.findFormationByReference(ref)
				.orElseThrow(() -> new TrainingNotFoundException("Training by reference " + ref + "was not found"));
	}

    public void deleteFormation(long id){
    	formationRepo.deleteFormationByIdFormation(id);
    }
    
    
	
}