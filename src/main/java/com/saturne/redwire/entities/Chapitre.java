package com.saturne.redwire.entities;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chapters")
public class Chapitre{ //implemets serializable??

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idChapter")
    private long idChap;

    @Column(name = "name")
    private String nomChapitre;

    @Column(name = "content")
    private String contenu;
    
    @ManyToOne
	@JoinColumn(name="idTraining") 
	private Formation formation= new Formation(); 

    public Chapitre() {}

    public Chapitre(String nomChapitre, String contenu) {
        this.nomChapitre = nomChapitre;
        this.contenu = contenu;
    }

    public Chapitre(long idChap, String nomChapitre, String contenu) {
        this.idChap = idChap;
        this.nomChapitre = nomChapitre;
        this.contenu = contenu;
    }

    public long getIdChap() {
        return idChap;
    }

    public void setIdChap(long idChap) {
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

    
    public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	@Override
    public String toString() {
        return "Chapitre [idChap=" + idChap + ", nomChapitre=" + nomChapitre + ", contenu=" + contenu + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(contenu, idChap, nomChapitre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Chapitre other = (Chapitre) obj;
        return Objects.equals(contenu, other.contenu) && idChap == other.idChap && Objects.equals(nomChapitre, other.nomChapitre);
    }
}

