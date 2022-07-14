package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Chapters")
public class Chapitre {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idChap;
	private String nomChapitre;
	private String Contenu;
	
	
	//on ne peut pas utiliser "mappedby" avec une relation @manytoOne!! => OK avec @OneToMany
	//@ManyToOne(mappedBy="chapters")
	
	@ManyToOne//(mappedBy="chapters")
	private Set<Formation> chap = new HashSet<Formation>();

	//Constructeur
	
	public Chapitre() {
		super();
	}


	public Chapitre(String idChap, String nomChapitre, String contenu) {
		super();
		this.idChap = idChap;
		this.nomChapitre = nomChapitre;
		Contenu = contenu;
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
		return Contenu;
	}


	public void setContenu(String contenu) {
		Contenu = contenu;
	}


	@Override
	public String toString() {
		return "Chapitre [idChap=" + idChap + ", nomChapitre=" + nomChapitre + ", Contenu=" + Contenu + "]";
	}
	
	
	
	
	
	
	
}
