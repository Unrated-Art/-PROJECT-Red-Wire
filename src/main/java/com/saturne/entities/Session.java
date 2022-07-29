package com.saturne.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

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

	@Column(name="sessionPrice")
	private float prixSession;

	//*sessions <--> 1 salle
	@ManyToOne/*(cascade=CascadeType.ALL)*/ //#!TODO: check cascade Type!!
	@JoinColumn(name="idSalle")
	private Salle salle = new Salle();

	//* sessions --> * stagiaires
	@ManyToMany/*(cascade=CascadeType.PERSIST) */////#!TODO: check cascade Type!!
	@JoinTable(name="sessions_trainees",
	joinColumns=@JoinColumn(name="sessions_ID"),
	inverseJoinColumns=@JoinColumn(name="trainees_ID"))
	private Set<Stagiaire> stagiaires = new HashSet<Stagiaire>();

	//1 session --> * evalSession 
	@OneToMany/*(cascade=CascadeType.ALL) */ //#!TODO: check cascade Type!!
	private Set<EvalSession> evalSessions = new HashSet<EvalSession>();

	//session *<-->1 formateur
	@ManyToOne/*(cascade=CascadeType.PERSIST)*/ //#!TODO: check cascade Type!!
	@JoinColumn(name="idFormateur")
	private Formateur formateur = new Formateur();

	
	//session *<-->1 formation
	@ManyToOne/*(cascade=CascadeType.PERSIST)*/  //#!TODO: check cascade Type!!
	@JoinColumn(name="idFormation")
	private Formation formation= new Formation();
	//private HashSet<Formation> formations = new HashSet<Formation>(); //by J-M

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

	public Set<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(Set<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public Set<EvalSession> getEvalSession() {
		return evalSessions;
	}

	public void setEvalSession(Set<EvalSession> evalSession) {
		this.evalSessions = evalSession;
	}

	
	
	//by J-M
//	public HashSet<Formation> getFormations() {
//		return formations;
//	}
//
//	public void setFormations(HashSet<Formation> formations) {
//		this.formations = formations;
//	}

	
	/**
	 * By nourhene
	 * 
	 */
	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
	/**
	 * END by nourhene
	 */

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateDebut, dateFin, idSession, lieu, prixSession);
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
				&& idSession == other.idSession && Objects.equals(lieu, other.lieu)
				&& Float.floatToIntBits(prixSession) == Float.floatToIntBits(other.prixSession);
	}
	
	// !#TODO: Annotation Many/One/Etc X-TO-X ==> done by nrhn le 16/07/2022
	
	
	
	
}
