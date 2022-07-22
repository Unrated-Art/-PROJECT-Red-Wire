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
	
	@Override
	public int hashCode() {
		return Objects.hash(chap, contenu, idChap, nomChapitre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chapitre other = (Chapitre) obj;
		return Objects.equals(chap, other.chap) && Objects.equals(contenu, other.contenu)
				&& Objects.equals(idChap, other.idChap) && Objects.equals(nomChapitre, other.nomChapitre);
	}

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


	public Set<Formation> getChap() {
		return chap;
	}

	public void setChap(Set<Formation> chap) {
		this.chap = chap;
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
