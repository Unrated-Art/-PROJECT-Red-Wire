package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="")
public class Chapitre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="")
	private String idChap;

    @Column(name="")
	private String nomChapitre;

    @Column(name="")
    private String contenu;
	
	
	//on ne peut pas utiliser "mappedby" avec une relation @manytoOne!! => OK avec @OneToMany
	//@ManyToOne(mappedBy="chapters")
	
    // !#TODO Update on errors
    // !#TODO: Generate EQUALS + HASHCODE upon use of HashSet
	@ManyToOne//(mappedBy="chapters") //
	private Set<Formation> chap = new HashSet<Formation>();

	//Constructeur
	
	public Chapitre() {}

	public Chapitre(String idChap, String nomChapitre, String contenu) {
		this.idChap = idChap;
		this.nomChapitre = nomChapitre;
		this.contenu = contenu;
	}

	
	//Getter et Setter
	

	public String getIdChap() {
		return idChap;
	}


	public void setIdChap(String idChap) {
		this.idChap = idChap;
	}


	public String getNomChapitre() {
		return nomChapitre;
	}


	public void setNomChapitre(String nomChapitre) {
		this.nomChapitre = nomChapitre;
	}


	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


	@Override
	public String toString() {
		return "Chapitre [idChap=" + idChap + ", nomChapitre=" + nomChapitre + ", Contenu=" + contenu + "]";
	}
	
	// Relation entre Chapitre + Formation
	// Many To One
}
