package com.entities.jeanmanno;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//STATUS: NOT-TESTED

@Entity 
@Table(name="trainees")
public class Stagiaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idTrainee")
	private long idStagiaire;

	@Column(name="lastName")
	private String nom;

	@Column(name="firstName")
	private String prenom;

	@Column(name="address")
	private String adresse;

	@Column(name="email")
	private String courriel;

	@Column(name="phoneNumber")
	private String numTelephone;

	@Column(name="company")
	private Boolean entreprise;

	@Column(name="contactInfo")
	private String coordonneesEntre;

	public Stagiaire() {}
	public Stagiaire(String nom, String prenom, String adresse, String courriel, String numTelephone, Boolean entreprise,
			String coordonneesEntre) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.courriel = courriel;
		this.numTelephone = numTelephone;
		this.entreprise = entreprise;
		this.coordonneesEntre = coordonneesEntre;
	}

	// idStagiaire ~ No SETTER -> AUTO-INCREMENTED VALUE
	public long getIdStagiaire() {
		return idStagiaire;
	}

	// nom
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	// prenom
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	// adresse
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	// courriel
	public String getCourriel() {
		return courriel;
	}
	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	// numTelephone
	public String getNumTelephone() {
		return numTelephone;
	}
	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}

	// entreprise
	public Boolean getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Boolean entreprise) {
		this.entreprise = entreprise;
	}

	// coordonneesEntre
	public String getCoordonneesEntre() {
		return coordonneesEntre;
	}
	public void setCoordonneesEntre(String coordonneesEntre) {
		this.coordonneesEntre = coordonneesEntre;
	}

	@Override
	public String toString() {
		return "Stagiaire [idStagiaire=" + idStagiaire + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", courriel=" + courriel + ", numTelephone=" + numTelephone + ", entreprise=" + entreprise
				+ ", coordonneesEntre=" + coordonneesEntre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresse, coordonneesEntre, courriel, entreprise, idStagiaire, nom, numTelephone, prenom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stagiaire other = (Stagiaire) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(coordonneesEntre, other.coordonneesEntre)
				&& Objects.equals(courriel, other.courriel) && Objects.equals(entreprise, other.entreprise)
				&& idStagiaire == other.idStagiaire && Objects.equals(nom, other.nom)
				&& Objects.equals(numTelephone, other.numTelephone) && Objects.equals(prenom, other.prenom);
	}
}
