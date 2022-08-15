package com.saturne.redwire.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trainers")
public class Formateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTrainer")
    private long idFormateur;

    @Column(name = "firstName")
    private String prenomF;

    @Column(name = "lastName")
    private String nomF;

    @Column(name = "cv")
    private String cv;

    public Formateur() {}

    public Formateur(String prenomF, String nomF, String cv) {
        this.prenomF = prenomF;
        this.nomF = nomF;
        this.cv = cv;
    }

    public Formateur(long idFormateur, String prenomF, String nomF, String cv) {
        this.idFormateur = idFormateur;
        this.prenomF = prenomF;
        this.nomF = nomF;
        this.cv = cv;
    }

    public long getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(long idFormateur) {
        this.idFormateur = idFormateur;
    }

    public String getPrenomF() {
        return prenomF;
    }

    public void setPrenomF(String prenomF) {
        this.prenomF = prenomF;
    }

    public String getNomF() {
        return nomF;
    }

    public void setNomF(String nomF) {
        this.nomF = nomF;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        return "Formateur [idFormateur=" + idFormateur + ", prenomF=" + prenomF + ", nomF=" + nomF + ", cv=" + cv + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(cv, idFormateur, nomF, prenomF);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Formateur other = (Formateur) obj;
        return (
            Objects.equals(cv, other.cv) &&
            idFormateur == other.idFormateur &&
            Objects.equals(nomF, other.nomF) &&
            Objects.equals(prenomF, other.prenomF)
        );
    }
}
