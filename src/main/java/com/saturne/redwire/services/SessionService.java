package com.saturne.redwire.services;

import com.saturne.redwire.entities.Session;
import com.saturne.redwire.repositories.SessionRepository;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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

    public Session getSession(long id) {
        return sessionRepository.getSessionByIdSession(id).orElseThrow();
    }

    public List<Session> getSessions(HashMap<String, Object> params) {
        Stream<Session> sessionsStream = sessionRepository.findAll().stream();
        if (params.containsKey("idTraining")) {
            sessionsStream =
                sessionsStream.filter(s -> {
                    if (s.getFormation() != null) {
                        return s.getFormation().getIdFormation() == Float.parseFloat(params.get("idTraining").toString());
                    }
                    return false;
                });
        }
        if (params.containsKey("dateStart")) {
            sessionsStream =
                sessionsStream.filter(s -> {
                    LocalDate dateStart = LocalDate.parse(params.get("dateStart").toString());
                    return dateStart.isBefore(s.getDateDebut());
                });
        }
        if (params.containsKey("dateEnd")) {
            sessionsStream =
                sessionsStream.filter(s -> {
                    LocalDate dateEnd = LocalDate.parse(params.get("dateEnd").toString());
                    return dateEnd.isAfter(s.getDateFin());
                });
        }
        if (params.containsKey("location")) {
            sessionsStream =
                sessionsStream.filter(s -> {
                    return s.getLieu().toUpperCase().contains(params.get("location").toString().toUpperCase());
                });
        }
        if (params.containsKey("price")) {
            sessionsStream =
                sessionsStream.filter(s -> {
                    return s.getPrix() < Float.parseFloat(params.get("price").toString());
                });
        }
        return sessionsStream.collect(Collectors.toList());
    }

    public void deleteSession(long id) {
        sessionRepository.deleteById(id);
    }

    public List<Session> saveAll(List<Session> listSessions) {
        return sessionRepository.saveAll(listSessions);
    }
}
