package entities;

import javax.persistence.Entity;

@Entity

public class Catalogue {

	private String idCatalogue;
	private String auteur;
	private String dateCreation;
	
	
	
//Constructeur
	
	public Catalogue() {
		super();
	}

	public Catalogue(String idCatalogue, String auteur, String dateCreation) {
		super();
		this.idCatalogue = idCatalogue;
		this.auteur = auteur;
		this.dateCreation = dateCreation;
	}

//Setter et Getter
	
	public String getIdCatalogue() {
		return idCatalogue;
	}

	public void setIdCatalogue(String idCatalogue) {
		this.idCatalogue = idCatalogue;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Catalogue [idCatalogue=" + idCatalogue + ", auteur=" + auteur + ", dateCreation=" + dateCreation + "]";
	}
	

	
}
