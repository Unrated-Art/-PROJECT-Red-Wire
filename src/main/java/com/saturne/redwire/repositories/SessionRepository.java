package com.saturne.redwire.repositories;

import com.saturne.redwire.entities.Session;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Session getReferenceByIdSession(long idSession);

    List<Session> findAllByIdFormation(long idFormation);
}
