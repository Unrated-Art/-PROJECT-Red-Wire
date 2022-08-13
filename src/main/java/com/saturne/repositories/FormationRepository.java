package com.saturne.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saturne.entities.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {

	Optional<Formation> findFormationByIdFormation(long idFormation);
	//Optional<Formation> findFormationById(Long id);
	
	Optional<Formation> findFormationByReference(String reference); 

	//List<Formation> findByKeyword(String keyword);

	void deleteFormationByIdFormation(long idFormation);
	
}
