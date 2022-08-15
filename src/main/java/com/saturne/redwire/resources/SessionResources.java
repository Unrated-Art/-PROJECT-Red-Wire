package com.saturne.redwire.resources;

import com.saturne.redwire.entities.Formation;
import com.saturne.redwire.entities.Session;
import com.saturne.redwire.services.FormationService;
import com.saturne.redwire.services.SessionService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class SessionResources {

    private final SessionService sessionService;

    @Autowired
    public SessionResources(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping(name = "create.session")
    @ResponseStatus(HttpStatus.CREATED)
    public Session createSession(
        @RequestParam(name = "idTraining") long idTraining,
        @RequestParam(name = "dateStart") String dateStart,
        @RequestParam(name = "dateEnd") String dateEnd,
        @RequestParam(name = "location") String location,
        @RequestParam(name = "price", defaultValue = "0") float price
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Session s = new Session();
        s.setDateDebut(LocalDate.parse(dateStart, formatter));
        s.setDateFin(LocalDate.parse(dateEnd, formatter));
        s.setLieu(location);
        s.setPrix(price);
        s = sessionService.createSession(s);

        try {
            FormationService fs = new FormationService();
            Formation training = fs.findFormationById(idTraining);
            s.setFormation(training);
            s = sessionService.updateSession(s);
        } catch (Exception e) {}

        return s;
    }

    @PutMapping(name = "update.session", path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Session updateSession(
        @PathVariable(name = "id") long idSession,
        @RequestParam(name = "dateStart", required = false) String dateStart,
        @RequestParam(name = "dateEnd", required = false) String dateEnd,
        @RequestParam(name = "location", required = false) String location,
        @RequestParam(name = "price", defaultValue = "0") float price,

        @RequestParam(name = "idClassroom", defaultValue = "0") long idClassroom,
        @RequestParam(name = "idTrainer", defaultValue = "0") long idTrainer,
        @RequestParam(name = "evalSessions[]", defaultValue="[]") String[] evalSessions,
        @RequestParam(name = "stagiaires[]", defaultValue="[]") String[] stagiaires
    ) {
        Session s = sessionService.getSession(idSession);
        if (s != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            if (dateStart != null) {
                s.setDateDebut(LocalDate.parse(dateStart, formatter));
            }
            if (dateEnd != null) {
                s.setDateFin(LocalDate.parse(dateEnd, formatter));
            }
            if (location != null) {
                s.setLieu(location);
            }
            if (price != 0.0f) {
                s.setPrix(price);
            }

            if (idClassroom > 0) {
            	//SalleService ss = new SalleService();
            	//Salle classroom = ss.getReferenceById(idClassroom);
            	//s.setSalle(classroom);
            }
            if (idTrainer > 0) {
            	//FormateurService fs = new FormateurService();
            	//Formateur trainer = ss.getReferenceById(idTrainer);
            	//s.setFormateur(trainer);
            }
            if (evalSessions.length > 0) {
            	//EvalSessionService ess = new EvalSessionService();
            	//List<EvalSession> evalSession = ess.findAllById(idEval);
            	//s.setEvalSessions(evalSession);
            }
            if (stagiaires.length > 0) {
            	//StagiaireService ss = new StagiaireService();
            	//List<Stagiaire> trainee = ss.findAllById(idTrainee);            	
            	//s.setStagiaires(trainee);
            }
            return sessionService.updateSession(s);
        }
        return null;
    }

    @GetMapping(name = "get.session", path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Session getSessionById(@PathVariable("id") long id) {
        return sessionService.getSession(id);
    }

    @GetMapping(name = "search.session")
    @ResponseStatus(HttpStatus.OK)
    public List<Session> getSessions(
        @RequestParam(value = "dateStart", required = false) String dateStart,
        @RequestParam(value = "dateEnd", required = false) String dateEnd,
        @RequestParam(value = "location", required = false) String location,
        @RequestParam(value = "price", required = false) String price
    ) {
        HashMap<String, String> params = new HashMap<>();
        if (dateStart != null) {
            params.put("dateStart", dateStart);
        }
        if (dateEnd != null) {
            params.put("dateEnd", dateEnd);
        }
        if (location != null) {
            params.put("location", location);
        }
        if (price != null) {
            params.put("price", price);
        }
        return sessionService.getSessions(params);
    }

    @DeleteMapping(name = "delete.session", path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSessionById(@PathVariable("id") long id) {
        Session s = sessionService.getSession(id);
        if (s != null) {
            sessionService.deleteSession(s.getIdSession());
        }
    }
}
