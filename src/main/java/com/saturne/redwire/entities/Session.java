package com.saturne.redwire.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSession")
    private long idSession;

    @Column(name = "dateStart")
    private String dateDebut;

    @Column(name = "dateEnd")
    private String dateFin;

    @Column(name = "location")
    private String lieu;

    @Column(name = "price")
    private float prix;

    public Session() {}

    public Session(String dateDebut, String dateFin, String lieu, float prix) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.lieu = lieu;
        this.prix = prix;
    }

    public Session(long idSession, String dateDebut, String dateFin, String lieu, float prix) {
        this.idSession = idSession;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.lieu = lieu;
        this.prix = prix;
    }

    public long getIdSession() {
        return idSession;
    }

    public void setIdSession(long idSession) {
        this.idSession = idSession;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return (
            "Session [idSession=" +
            idSession +
            ", dateDebut=" +
            dateDebut +
            ", dateFin=" +
            dateFin +
            ", lieu=" +
            lieu +
            ", prix=" +
            prix +
            "]"
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateDebut, dateFin, idSession, lieu, prix);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Session other = (Session) obj;
        return (
            Objects.equals(dateDebut, other.dateDebut) &&
            Objects.equals(dateFin, other.dateFin) &&
            idSession == other.idSession &&
            Objects.equals(lieu, other.lieu) &&
            Float.floatToIntBits(prix) == Float.floatToIntBits(other.prix)
        );
    }
}
