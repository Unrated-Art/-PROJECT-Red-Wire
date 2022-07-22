package com.entities.charline;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.entities.jeanmanno.Formation;

//STATUS: NOT-TESTED

@Entity 
@Table(name="chapters")
public class Chapitre {

	@Id
	@Column(name="idChapter")
	private String idChapter;

    @Column(name="name")
	private String nomChapitre;

    @Column(name="content")
    private String contenu;

    @ManyToOne()
    @JoinColumn(name="idTraining", referencedColumnName="idTraining")
    private Formation formation= new Formation();

	public Chapitre() {}
	public Chapitre(String idChapter, String nomChapitre, String contenu) {
		this.idChapter = idChapter;
		this.nomChapitre = nomChapitre;
		this.contenu = contenu;
	}

	// idChapter
	public String getIdChapter() {
		return idChapter;
	}
	public void setIdChapter(String idChapter) {
		this.idChapter = idChapter;
	}

	// nomChapitre
	public String getNomChapitre() {
		return nomChapitre;
	}
	public void setNomChapitre(String nomChapitre) {
		this.nomChapitre = nomChapitre;
	}

	// contenu
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	// formation
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	@Override
	public String toString() {
		return "Chapitre [idChapter=" + idChapter + ", nomChapitre=" + nomChapitre + ", contenu=" + contenu + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contenu, formation, idChapter, nomChapitre);
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
		return Objects.equals(contenu, other.contenu) && Objects.equals(formation, other.formation)
				&& Objects.equals(idChapter, other.idChapter) && Objects.equals(nomChapitre, other.nomChapitre);
	}
}
