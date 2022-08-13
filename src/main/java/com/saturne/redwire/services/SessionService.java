package com.saturne.redwire.services;

import com.saturne.redwire.entities.Session;
import com.saturne.redwire.repositories.SessionRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		return sessionRepository.getReferenceByIdSession(id);
	}

	public List<Session> getSessions(HashMap<String, String> params) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Stream<Session> sessionsStream = sessionRepository.findAll().stream();
		if (params.containsKey("dateStart")) {
			sessionsStream = sessionsStream.filter(
				s -> LocalDate.parse(params.get("dateStart"), f).isBefore(s.getDateDebut())
			);
		}
		if (params.containsKey("dateEnd")) {
			sessionsStream = sessionsStream.filter(
				s -> LocalDate
				.parse(params.get("dateEnd"), f)
				.isAfter(s.getDateFin())
			);
		}
		if (params.containsKey("location")) {
			sessionsStream = sessionsStream.filter(
				s -> s.getLieu().toUpperCase().contains(params.get("location").toUpperCase())
			);
		}
		if (params.containsKey("price")) {
			System.out.println(Float.parseFloat(params.get("price")));
			sessionsStream = sessionsStream.filter(
				s -> Float.parseFloat(params.get("price")) > s.getPrix()
			);
		}
		return sessionsStream.collect(Collectors.toList());
	}

	public void deleteSession(long id) {
		sessionRepository.deleteById(id);
	}
}
