package com.saturne.redwire.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trainees")
public class Stagiaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTrainee")
    private long idStagiaire;

    @Column(name = "lastName")
    private String nom;

    @Column(name = "firstName")
    private String prenom;

    @Column(name = "address")
    private String adresse;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String numTelephone;

    @Column(name = "password")
    private String mpass;

    @Column(name = "company")
    private Boolean entreprise;

    @Column(name = "contactInfo")
    private String coordonneesEntre;

    public Stagiaire() {}

    public Stagiaire(
        String nom,
        String prenom,
        String adresse,
        String email,
        String numTelephone,
        String mpass,
        Boolean entreprise,
        String coordonneesEntre
    ) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.numTelephone = numTelephone;
        this.mpass = mpass;
        this.entreprise = entreprise;
        this.coordonneesEntre = coordonneesEntre;
    }

    public Stagiaire(
        long idStagiaire,
        String nom,
        String prenom,
        String adresse,
        String email,
        String numTelephone,
        String mpass,
        Boolean entreprise,
        String coordonneesEntre
    ) {
        this.idStagiaire = idStagiaire;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.numTelephone = numTelephone;
        this.mpass = mpass;
        this.entreprise = entreprise;
        this.coordonneesEntre = coordonneesEntre;
    }

    public long getIdStagiaire() {
        return idStagiaire;
    }

    public void setIdStagiaire(long idStagiaire) {
        this.idStagiaire = idStagiaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTelephone() {
        return numTelephone;
    }

    public void setNumTelephone(String numTelephone) {
        this.numTelephone = numTelephone;
    }

    public String getMpass() {
        return mpass;
    }

    public void setMpass(String mpass) {
        this.mpass = mpass;
    }

    public Boolean getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Boolean entreprise) {
        this.entreprise = entreprise;
    }

    public String getCoordonneesEntre() {
        return coordonneesEntre;
    }

    public void setCoordonneesEntre(String coordonneesEntre) {
        this.coordonneesEntre = coordonneesEntre;
    }

    @Override
    public String toString() {
        return (
            "Stagiaire [idStagiaire=" +
            idStagiaire +
            ", nom=" +
            nom +
            ", prenom=" +
            prenom +
            ", adresse=" +
            adresse +
            ", email=" +
            email +
            ", numTelephone=" +
            numTelephone +
            ", mpass=" +
            mpass +
            ", entreprise=" +
            entreprise +
            ", coordonneesEntre=" +
            coordonneesEntre +
            "]"
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(adresse, coordonneesEntre, email, entreprise, idStagiaire, mpass, nom, numTelephone, prenom);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Stagiaire other = (Stagiaire) obj;
        return (
            Objects.equals(adresse, other.adresse) &&
            Objects.equals(coordonneesEntre, other.coordonneesEntre) &&
            Objects.equals(email, other.email) &&
            Objects.equals(entreprise, other.entreprise) &&
            idStagiaire == other.idStagiaire &&
            Objects.equals(mpass, other.mpass) &&
            Objects.equals(nom, other.nom) &&
            Objects.equals(numTelephone, other.numTelephone) &&
            Objects.equals(prenom, other.prenom)
        );
    }
}
