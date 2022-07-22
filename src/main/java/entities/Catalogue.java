package entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	
	@OneToMany (mappedBy="catalog")
	
	
	
	private Set<Formation> catalog = new HashSet<Formation>();
	
//Constructeur
	
	@Override
	public int hashCode() {
		return Objects.hash(auteur, catalog, dateCreation, idCatalogue);
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
		return Objects.equals(auteur, other.auteur) && Objects.equals(catalog, other.catalog)
				&& Objects.equals(dateCreation, other.dateCreation) && idCatalogue == other.idCatalogue;
	}

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

	public Set<Formation> getCatalog() {
		return catalog;
	}

	public void setCatalog(Set<Formation> catalog) {
		this.catalog = catalog;
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
	
}
