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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.entities.charline.Chapitre;
import com.entities.patrick.PreTest;
import com.entities.patrick.Theme;

//STATUS: NOT-TESTED

@Entity
@Table(name="trainings")
public class Formation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTraining")
	private long idFormation;

	@Column(name="ref")
	private String reference;

	@Column(name="location")
	private String lieu;

	@Column(name="interTraining")
	private Boolean interFormation;

	@Column(name="duration")
	private int duree;

	@Column(name="requirements")
	private String prerequis;

	@Column(name="goal")
	private String objectif;

	@Column(name="targetAudience")
	private String publicVise;

	@Column(name="details")
	private String programmeDetaille;

	@OneToOne()
	@JoinColumn(name="idTest")
	private PreTest pretest = new PreTest();

	@OneToMany(mappedBy="formation")
	private Set<Session> sessions = new HashSet<Session>();

    @ManyToMany()
    @JoinTable(
		name="training_themes",
		joinColumns={ @JoinColumn(name="idTraining", referencedColumnName="idTraining") },
		inverseJoinColumns={ @JoinColumn(name="idTheme", referencedColumnName="idTheme") }
	)
	private Set<Theme> themes = new HashSet<Theme>();
    // MANY-TO-MANY -> UNIDIRECTIONAL

	@OneToMany(mappedBy="formation")
	private Set<Chapitre> chapitres = new HashSet<Chapitre>();

	public Formation() {}
	public Formation(String reference, String lieu, Boolean interFormation, int duree,
			String prerequis, String objectif, String publicVise, String programmeDetaille) {
		this.reference = reference;
		this.lieu = lieu;
		this.interFormation = interFormation;
		this.duree = duree;
		this.prerequis = prerequis;
		this.objectif = objectif;
		this.publicVise = publicVise;
		this.programmeDetaille = programmeDetaille;
	}

	// idFormation ~ No SETTER -> AUTO-INCREMENTED VALUE  => we need the setter here!! (nrhn)
	
	public long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(long idFormation) {
		this.idFormation = idFormation;
	}
	
	// reference
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}

	// lieu
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	// interFormation
	public Boolean getInterFormation() {
		return interFormation;
	}
	public void setInterFormation(Boolean interFormation) {
		this.interFormation = interFormation;
	}

	// duree
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}

	// prerequis
	public String getPrerequis() {
		return prerequis;
	}
	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	// objectif
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	// publicVise
	public String getPublicVise() {
		return publicVise;
	}
	public void setPublicVise(String publicVise) {
		this.publicVise = publicVise;
	}

	// programmeDetaille
	public String getProgrammeDetaille() {
		return programmeDetaille;
	}
	public void setProgrammeDetaille(String programmeDetaille) {
		this.programmeDetaille = programmeDetaille;
	}

	// pretest
	public PreTest getPretest() {
		return pretest;
	}
	public void setPretest(PreTest pretest) {
		this.pretest = pretest;
	}

	// sessions
	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	// themes
	public Set<Theme> getThemes() {
		return themes;
	}
	public void setThemes(Set<Theme> themes) {
		this.themes = themes;
	}

	// chapitres
	public Set<Chapitre> getChapitres() {
		return chapitres;
	}
	public void setChapitres(Set<Chapitre> chapitres) {
		this.chapitres = chapitres;
	}

	@Override
	public String toString() {
		return "Formation [idFormation=" + idFormation + ", reference=" + reference + ", lieu=" + lieu
				+ ", interFormation=" + interFormation + ", duree=" + duree + ", prerequis=" + prerequis + ", objectif="
				+ objectif + ", publicVise=" + publicVise + ", programmeDetaille=" + programmeDetaille + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(chapitres, duree, idFormation, interFormation, lieu, objectif, prerequis, pretest,
				programmeDetaille, publicVise, reference, sessions, themes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formation other = (Formation) obj;
		return Objects.equals(chapitres, other.chapitres) && duree == other.duree && idFormation == other.idFormation
				&& Objects.equals(interFormation, other.interFormation) && Objects.equals(lieu, other.lieu)
				&& Objects.equals(objectif, other.objectif) && Objects.equals(prerequis, other.prerequis)
				&& Objects.equals(pretest, other.pretest) && Objects.equals(programmeDetaille, other.programmeDetaille)
				&& Objects.equals(publicVise, other.publicVise) && Objects.equals(reference, other.reference)
				&& Objects.equals(sessions, other.sessions) && Objects.equals(themes, other.themes);
	}
}
