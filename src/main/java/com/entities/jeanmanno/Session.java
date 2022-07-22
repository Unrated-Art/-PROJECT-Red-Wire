package com.entities.jeanmanno;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.entities.charline.Salle;
import com.entities.nourhene.EvalSession;
import com.entities.nourhene.Formateur;

//STATUS: NOT-TESTED

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

	@Column(name="sessionPrice")
	private float prixSession;

	@ManyToOne()
	@JoinColumn(name="idClassroom", nullable=false)
	private Salle salle = new Salle();

	@ManyToMany()
	@JoinTable(
		name="sessions_trainees",
		joinColumns={@JoinColumn(name="idSession")},
		inverseJoinColumns={@JoinColumn(name="idTrainee")}
	)
	private Set<Stagiaire> stagiaires = new HashSet<Stagiaire>();

	@OneToMany()
	@JoinTable(
		name="session_evaluations",
		joinColumns={ @JoinColumn(name="idSession", referencedColumnName="idSession") },
		inverseJoinColumns={ @JoinColumn(name="idEvaluation", referencedColumnName="idEvaluation") }
	)
	private Set<EvalSession> evalSession = new HashSet<EvalSession>();
	// ONE-TO-MANY -> UNIDIRECTIONAL

	@ManyToOne()
	@JoinColumn(name="idTrainer", nullable=false)
	private Formateur formateur = new Formateur();

	@ManyToOne()
	@JoinColumn(name="idTraining", nullable=false)
	private Formation formation = new Formation();

	public Session() {}
	public Session(String dateDebut, String dateFin, String lieu, float prixSession) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.lieu = lieu;
		this.prixSession = prixSession;
	}

	// idSession ~ GETTER ONLY
	public long getIdSession() {
		return idSession;
	}

	// dateDebut
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	// dateFin
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	// lieu
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	// prixSession
	public float getPrixSession() {
		return prixSession;
	}
	public void setPrixSession(float prixSession) {
		this.prixSession = prixSession;
	}

	// stagiaires
	public Set<Stagiaire> getStagiaires() {
		return stagiaires;
	}
	public void setStagiaires(Set<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	// evalSession
	public Set<EvalSession> getEvalSession() {
		return evalSession;
	}
	public void setEvalSession(Set<EvalSession> evalSession) {
		this.evalSession = evalSession;
	}

	// salle
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	// formateur
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	// formation
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	@Override
	public String toString() {
		return "Session [idSession=" + idSession + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", lieu="
				+ lieu + ", prixSession=" + prixSession + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateDebut, dateFin, evalSession, formateur, formation, idSession, lieu, prixSession, salle,
				stagiaires);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Session other = (Session) obj;
		return Objects.equals(dateDebut, other.dateDebut) && Objects.equals(dateFin, other.dateFin)
				&& Objects.equals(evalSession, other.evalSession) && Objects.equals(formateur, other.formateur)
				&& Objects.equals(formation, other.formation) && idSession == other.idSession
				&& Objects.equals(lieu, other.lieu)
				&& Float.floatToIntBits(prixSession) == Float.floatToIntBits(other.prixSession)
				&& Objects.equals(salle, other.salle) && Objects.equals(stagiaires, other.stagiaires);
	}
}
