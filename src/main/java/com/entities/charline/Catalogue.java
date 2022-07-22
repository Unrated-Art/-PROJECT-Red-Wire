package com.entities.charline;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.entities.jeanmanno.Formation;

//STATUS: NOT-TESTED

@Entity 
@Table(name="catalogues")
public class Catalogue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCatalogue")
	private int idCatalogue;

	@Column(name="author")
	private String auteur;

	@Column(name="creationDate")
	private String dateCreation;

	@OneToMany()
	@JoinTable(
		name="catalogue_trainings",
		joinColumns={ @JoinColumn(name="idCatalogue", referencedColumnName="idCatalogue") },
		inverseJoinColumns={ @JoinColumn(name="idTraining", referencedColumnName="idTraining") }
	)
	private Set<Formation> formations = new HashSet<Formation>();
	// ONE-TO-MANY -> UNIDIRECTIONAL

	// 
	public Catalogue() {}
	public Catalogue(String auteur, String dateCreation) {
		this.auteur = auteur;
		this.dateCreation = dateCreation;
	}

	// idCatalogue ~ No SETTER -> AUTO-INCREMENTED VALUE
	public int getIdCatalogue() {
		return idCatalogue;
	}

	// auteur
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	// dateCreation
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	// formations
	public Set<Formation> getFormations() {
		return formations;
	}
	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	@Override
	public String toString() {
		return "Catalogue [idCatalogue=" + idCatalogue + ", auteur=" + auteur + ", dateCreation=" + dateCreation
				+ ", formations=" + formations + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(auteur, dateCreation, formations, idCatalogue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Catalogue other = (Catalogue) obj;
		return Objects.equals(auteur, other.auteur) && Objects.equals(dateCreation, other.dateCreation)
				&& Objects.equals(formations, other.formations) && idCatalogue == other.idCatalogue;
	}
}
