package com.saturne.redwire.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classrooms")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClassroom")
    private long idSalle;

    @Column(name = "roomNumber")
    private String numSalle;

    @Column(name = "floorNumber")
    private String etage;

    @Column(name = "address")
    private String adresse;

    public Salle() {}

    public Salle(String numSalle, String etage, String adresse) {
        this.numSalle = numSalle;
        this.etage = etage;
        this.adresse = adresse;
    }

    public Salle(long idSalle, String numSalle, String etage, String adresse) {
        this.idSalle = idSalle;
        this.numSalle = numSalle;
        this.etage = etage;
        this.adresse = adresse;
    }

    public long getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(long idSalle) {
        this.idSalle = idSalle;
    }

    public String getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(String numSalle) {
        this.numSalle = numSalle;
    }

    public String getEtage() {
        return etage;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Salle [idSalle=" + idSalle + ", numSalle=" + numSalle + ", etage=" + etage + ", adresse=" + adresse + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(adresse, etage, idSalle, numSalle);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Salle other = (Salle) obj;
        return (
            Objects.equals(adresse, other.adresse) &&
            Objects.equals(etage, other.etage) &&
            idSalle == other.idSalle &&
            Objects.equals(numSalle, other.numSalle)
        );
    }
}
