package com.saturne.redwire.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saturne.redwire.entities.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
