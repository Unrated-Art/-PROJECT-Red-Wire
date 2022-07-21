package entities;

import java.util.HashSet;

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
	private HashSet<Themes> themes = new HashSet<Themes>();
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

	public HashSet<Themes> getThemes() {
		return themes;
	}

	public void setThemes(HashSet<Themes> themes) {
		this.themes = themes;
	}

	public PreTest getPretest() {
		return pretest;
	}

	public void setPretest(PreTest pretest) {
		this.pretest = pretest;
	}

	public ArrayList<Session> getSession() {
		return session;
	}

	public void setSession(HashSet<Session> session) {
		this.session = session;
	}
}
