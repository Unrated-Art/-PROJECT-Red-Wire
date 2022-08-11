package com.saturne.redwire.controllers;

import com.saturne.redwire.entities.Session;
import com.saturne.redwire.services.SessionService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/session")
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping(name = "create.session")
    @ResponseStatus(HttpStatus.CREATED)
    public Session createSession(
        @RequestParam(name = "dateDebut") String dateDebut,
        @RequestParam(name = "dateFin") String dateFin,
        @RequestParam(name = "lieu") String lieu,
        @RequestParam(name = "prix", defaultValue = "0") float prix
    ) {
        Session s = new Session();
        s.setDateDebut(dateDebut);
        s.setDateFin(dateFin);
        s.setLieu(lieu);
        s.setPrix(prix);
        return sessionService.createSession(s);
    }

    @PutMapping(name = "update.session", path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Session updateSession(
        @PathVariable(name = "id") long id,
        @RequestParam(name = "dateDebut", required = false) String dateDebut,
        @RequestParam(name = "dateFin", required = false) String dateFin,
        @RequestParam(name = "lieu", required = false) String lieu,
        @RequestParam(name = "prix", defaultValue = "0") float prix
    ) {
        Session s = sessionService.getSessionByIdSession(id);
        if (s != null) {
            if (dateDebut != null) {
                s.setDateDebut(dateDebut);
            }
            if (dateFin != null) {
                s.setDateFin(dateFin);
            }
            if (lieu != null) {
                s.setLieu(lieu);
            }
            if (prix != 0.0f) {
                s.setPrix(prix);
            }
            return sessionService.updateSession(s);
        }
        return null;
    }

    @GetMapping(name = "get.session", path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Session getSessionById(@PathVariable("id") long id) {
        return sessionService.getSessionByIdSession(id);
    }

    @SuppressWarnings("unchecked")
    @GetMapping(name = "search.session")
    @ResponseStatus(HttpStatus.OK)
    public List<Session> getSessions(@RequestParam(value = "q", required = false) String keyword) {
        return sessionService.getSessions((HashMap<String, String>) List.of());
    }

    @DeleteMapping(name = "delete.session", path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSessionById(@PathVariable("id") long id) {
        Session s = sessionService.getSessionByIdSession(id);
        if (s != null) {
            sessionService.deleteSessionById(id);
        }
    }
}
