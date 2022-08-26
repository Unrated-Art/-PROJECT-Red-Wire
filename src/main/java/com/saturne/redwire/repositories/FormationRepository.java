package com.saturne.redwire.repositories;

import com.saturne.redwire.entities.Formation;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Long> {
    Optional<Formation> findFormationByIdFormation(long idFormation);
    //Optional<Formation> findFormationById(Long id);

    Optional<Formation> findFormationByReference(String reference);

    //List<Formation> findByKeyword(String keyword);

    void deleteFormationByIdFormation(long idFormation);
}
