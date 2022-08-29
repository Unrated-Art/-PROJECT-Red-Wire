package com.saturne.redwire.repositories;

import com.saturne.redwire.entities.Session;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
  Optional<Session> getSessionByIdSession(long idSession);

  void deleteByIdSession(long id);
}
