package com.saturne.redwire.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "catalogues")
public class Catalogue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCatalogue")
    private int idCatalogue;

    @Column(name = "title")
    private String titre;

    @Column(name = "creationDate")
    private String dateCreation;

    
   //"title": "titre1",
    //"creationDate": "20janv 2022"
    
    
    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "idAuthor")
    @Column(name = "auteur")
    private String auteur;

    public Catalogue() {}

    public Catalogue(String titre, String dateCreation) {
        this.titre = titre;
        this.dateCreation = dateCreation;
    }

    public Catalogue(int idCatalogue, String titre, String dateCreation) {
        this.idCatalogue = idCatalogue;
        this.titre = titre;
        this.dateCreation = dateCreation;
    }

    public int getIdCatalogue() {
        return idCatalogue;
    }

    public void setIdCatalogue(int idCatalogue) {
        this.idCatalogue = idCatalogue;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Catalogue [idCatalogue=" + idCatalogue + ", titre=" + titre + ", dateCreation=" + dateCreation + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateCreation, idCatalogue, titre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Catalogue other = (Catalogue) obj;
        return Objects.equals(dateCreation, other.dateCreation) && idCatalogue == other.idCatalogue && Objects.equals(titre, other.titre);
    }
}
