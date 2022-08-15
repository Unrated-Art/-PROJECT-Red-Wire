package com.saturne.redwire.services;

import com.saturne.redwire.entities.Formation;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FormationService {

    //injection de dépendance
    // @Autowired
    // private FormationRepository formationRepo;

    /**
     * @param formation
     * @return
     */
    public Formation addFormation(Formation f) {
        //return formationRepo.save(f);
        return f;
    }

    /**
     *
     * @return List<Formation>
     */
    public List<Formation> findAllFormations() {
        // return formationRepo.findAll();
        return List.of();
    }

    /**
     * @param formation
     * @return Formation
     */
    public Formation updateFormation(Formation formation) {
        // return formationRepo.save(formation);
        return formation;
    }

    /**
     * @param id
     * @return Formation
     */
    public Formation findFormationById(long id) {
        Formation f = new Formation();
        return f;
        // return formationRepo.findFormationByIdFormation(id);
        /*
                .orElseThrow(() -> new TrainingNotFoundException("Training by id " + id + " was not found"));
        */
    }

    /**
     *
     * @param keyword
     * @return List<Formation> containing 'keyword'
     */
    public List<Formation> findByKeyword(String keyword) {
        return List.of();
        /*
		return formationRepo.findAll().stream()
				.filter(f -> ((f.getReference()).toUpperCase()).contains(keyword.toUpperCase())
        				|| ((f.getTitref()).toUpperCase()).contains(keyword.toUpperCase()) 
        				|| ((f.getLieu()).toUpperCase()).contains(keyword.toUpperCase()) 
        				|| ((f.getObjectif()).toUpperCase()).contains(keyword.toUpperCase()) 
        				|| ((f.getPrerequis()).toUpperCase()).contains(keyword.toUpperCase()) 
        				|| ((f.getProgrammeDetaille()).toUpperCase()).contains(keyword.toUpperCase()) 
        				|| ((f.getPublicVise()).toUpperCase()).contains(keyword.toUpperCase()))
        				|| ((f.getThemes().foreach()????.contains(keyword.toLowerCase())
        				.collect(Collectors.toList());
				//.orElseThrow(() -> new TrainingNotFoundException("Training by keyword " + keyword + "was not found"));	
		*/
    }

    /***
     * @param ref
     * @return Formation
     */
    public Formation findFormationByReference(String ref) {
        Formation f = new Formation();
        return f;
        /*
		return formationRepo.findFormationByReference(ref)
				.orElseThrow(() -> new TrainingNotFoundException("Training by reference " + ref + "was not found"));
		*/
    }

    /**
     * #TODO: rajouter methode updateFormation
     */

    /**
     *
     * @param id
     */
    public void deleteFormation(long id) {
        // formationRepo.deleteFormationByIdFormation(id);
    }
}
