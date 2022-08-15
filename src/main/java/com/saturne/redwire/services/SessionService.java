package com.saturne.redwire.services;

import com.saturne.redwire.entities.Session;
import com.saturne.redwire.repositories.SessionRepository;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session createSession(Session s) {
        return sessionRepository.saveAndFlush(s);
    }

    public Session updateSession(Session s) {
        return sessionRepository.save(s);
    }

    public Session getSessionByIdSession(Long id) {
        return sessionRepository.getReferenceByIdSession(id);
    }

    public List<Session> getSessions(HashMap<String, String> keywords) {
        if (keywords.size() != 0) {
            // Filtrer
            // sessionRepository.findAll()
        }
        return sessionRepository.findAll();
    }

    public void deleteSessionById(Long id) {
        // boolean status = false;
        sessionRepository.deleteById(id);
    }
}
