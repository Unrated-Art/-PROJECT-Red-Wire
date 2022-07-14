package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="") // translate to plurial in english
public class Catalogue {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCatalogue")
	private int idCatalogue; // Changed from `String` to `int`

	@Column(name="")
	private String auteur; // A voir avec Entity 'Admin/Manager' `int idAdmin`

	@Column(name="")
	private String dateCreation;

	
//Constructeur
	
	public Catalogue() {
		super();
	}

	public Catalogue(int idCatalogue, String auteur, String dateCreation) {
		super();
		this.idCatalogue = idCatalogue;
		this.auteur = auteur;
		this.dateCreation = dateCreation;
	}

//Setter et Getter
	
	public int getIdCatalogue() {
		return idCatalogue;
	}

	public void setIdCatalogue(int idCatalogue) {
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
	

	// Relation entre Catalogue + Formation
	// One To Many
}
