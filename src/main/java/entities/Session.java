package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	/* ****************** */
	/* Attributes START */
	@Column(name="dateStart")
	private String dateDebut;

	@Column(name="dateEnd")
	private String dateFin;

	@Column(name="location")
	private String lieu;

	@Column(name="priceSession")
	private float prixSession;
	/* Attributes END */
	/* ****************** */

	/* ****************** */
	/* Associations START */
	// @Column(name="classroom")
	@OneToOne
	@MapsId
	private Salle salle = new Salle();

	// @Column(name="trainer")
	@OneToOne
	@MapsId
	private Formateur formateur = new Formateur();

	// @Column(name="evalSessions")
	@OneToMany(orphanRemoval=true)
	@JoinColumn(name="idEval")
	private Set<EvalSession> evalSessions = new HashSet<EvalSession>();

	// @Column(name="training")
	@ManyToOne()
	private Formation formation = new Formation();

	// @Column(name="trainees")
	// @ManyToMany NOT implemented because it is UNI-directional.
	private Set<Stagiaire> stagiaires = new HashSet<Stagiaire>();
	/* Associations END */
	/* ****************** */

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

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Set<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(HashSet<Stagiaire> stagiaires) {
		this.stagiaires.addAll(stagiaires);
	}

	public Set<EvalSession> getEvalSessions() {
		return evalSessions;
	}

	public void setEvalSessions(HashSet<EvalSession> evalSessions) {
		this.evalSessions.addAll(evalSessions);
	}

	public Formation getFormations() {
		return formation;
	}

	public void setFormations(Formation formation) {
		this.formation = formation;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	@Override
	public String toString() {
		return "Session [idSession=" + idSession + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", lieu="
				+ lieu + ", prixSession=" + prixSession + "]";
	}
}
