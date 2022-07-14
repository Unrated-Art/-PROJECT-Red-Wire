package entities;

import java.util.HashSet;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Formations
 */
@Entity
@Table(name="trainings")
public class Formation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTraining")
	private long idFormation;

	@Column(name="name")
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

	private HashSet<Chapitre> chapitres = new HashSet<Chapitre>();
	private HashSet<Theme> themes = new HashSet<Theme>();
	private PreTest pretest = new PreTest();
	private HashSet<Session> session = new HashSet<Session>();

	public Formation() {}

	public Formation(String reference, String lieu, Boolean interFormation, int duree, String prerequis,
			String objectif, String publicVise, String programmeDetaille) {
		this.reference = reference;
		this.lieu = lieu;
		this.interFormation = interFormation;
		this.duree = duree;
		this.prerequis = prerequis;
		this.objectif = objectif;
		this.publicVise = publicVise;
		this.programmeDetaille = programmeDetaille;
	}

	public long getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(long idFormation) {
		this.idFormation = idFormation;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Boolean getInterFormation() {
		return interFormation;
	}
	public void setInterFormation(Boolean interFormation) {
		this.interFormation = interFormation;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getPrerequis() {
		return prerequis;
	}
	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public String getPublicVise() {
		return publicVise;
	}
	public void setPublicVise(String publicVise) {
		this.publicVise = publicVise;
	}
	public String getProgrammeDetaille() {
		return programmeDetaille;
	}
	public void setProgrammeDetaille(String programmeDetaille) {
		this.programmeDetaille = programmeDetaille;
	}

	@Override
	public String toString() {
		return "Formation [idFormation=" + idFormation + ", reference=" + reference + ", lieu=" + lieu
				+ ", interFormation=" + interFormation + ", duree=" + duree + ", prerequis=" + prerequis + ", objectif="
				+ objectif + ", publicVise=" + publicVise + ", programmeDetaille=" + programmeDetaille + "]";
	}

	
	
	public HashSet<Chapitre> getChapitres() {
		return chapitres;
	}

	public void setChapitres(HashSet<Chapitre> chapitres) {
		this.chapitres = chapitres;
	}

	public HashSet<Theme> getThemes() {
		return themes;
	}

	public void setThemes(HashSet<Theme> themes) {
		this.themes = themes;
	}

	public PreTest getPretest() {
		return pretest;
	}

	public void setPretest(PreTest pretest) {
		this.pretest = pretest;
	}

	public HashSet<Session> getSession() {
		return session;
	}

	public void setSession(HashSet<Session> session) {
		this.session = session;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chapitres, duree, idFormation, interFormation, lieu, objectif, prerequis, programmeDetaille,
				publicVise, reference, session, themes);
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
				&& Objects.equals(programmeDetaille, other.programmeDetaille)
				&& Objects.equals(publicVise, other.publicVise) && Objects.equals(reference, other.reference)
				&& Objects.equals(session, other.session) && Objects.equals(themes, other.themes);
	}
	
	
	
}
