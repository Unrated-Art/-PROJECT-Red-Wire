package entities;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Sessions
 */
@Entity
@Table(name="sessions")
public class Session {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idSession")
	private long idSession;

	@Column(name="dateStart")
	private String dateDebut;

	@Column(name="dateEnd")
	private String dateFin;

	@Column(name="location")
	private String lieu;

	@Column(name="priceSession")
	private float prixSession;

	private Salle salle = new Salle();
	private HashSet<Stagiaire> stagiaires = new HashSet<Stagiaire>();

	@Column(name="")
	private HashSet<EvalSession> evalSessions = new HashSet<EvalSession>();

	@Column(name="")
	private Formateur formateur = new Formateur();

	public Session() {}

	public Session(String dateDebut, String dateFin, String lieu, float prixSession) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.lieu = lieu;
		this.prixSession = prixSession;
	}

	public long getIdSession() {
		return idSession;
	}
	public void setIdSession(long idSession) {
		this.idSession = idSession;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public float getPrixSession() {
		return prixSession;
	}
	public void setPrixSession(float prixSession) {
		this.prixSession = prixSession;
	}

	@Override
	public String toString() {
		return "Session [idSession=" + idSession + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", lieu="
				+ lieu + ", prixSession=" + prixSession + "]";
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public HashSet<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(HashSet<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public HashSet<EvalSession> getEvalSession() {
		return evalSessions;
	}

	public void setEvalSession(HashSet<EvalSession> evalSession) {
		this.evalSessions = evalSession;
	}

	public HashSet<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(HashSet<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
}
