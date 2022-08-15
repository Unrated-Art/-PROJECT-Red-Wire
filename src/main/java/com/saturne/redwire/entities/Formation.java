package com.saturne.redwire.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trainings")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTraining")
    private long idFormation;

    @Column(name = "ref")
    private String reference;

    @Column(name = "title")
    private String titref;

    @Column(name = "location")
    private String lieu;

    @Column(name = "interTraining")
    private Boolean interFormation;

    @Column(name = "duration")
    private int duree;

    @Column(name = "requirements")
    private String prerequis;

    @Column(name = "goal")
    private String objectif;

    @Column(name = "targetAudience")
    private String publicVise;

    @Column(name = "details")
    private String programmeDetaille;

    public Formation() {}

    public Formation(
        String reference,
        String titref,
        String lieu,
        Boolean interFormation,
        int duree,
        String prerequis,
        String objectif,
        String publicVise,
        String programmeDetaille
    ) {
        this.reference = reference;
        this.titref = titref;
        this.lieu = lieu;
        this.interFormation = interFormation;
        this.duree = duree;
        this.prerequis = prerequis;
        this.objectif = objectif;
        this.publicVise = publicVise;
        this.programmeDetaille = programmeDetaille;
    }

    public Formation(
        long idFormation,
        String reference,
        String titref,
        String lieu,
        Boolean interFormation,
        int duree,
        String prerequis,
        String objectif,
        String publicVise,
        String programmeDetaille
    ) {
        this.idFormation = idFormation;
        this.reference = reference;
        this.titref = titref;
        this.lieu = lieu;
        this.interFormation = interFormation;
        this.duree = duree;
        this.prerequis = prerequis;
        this.objectif = objectif;
        this.publicVise = publicVise;
        this.programmeDetaille = programmeDetaille;
    }

    @Override
    public String toString() {
        return (
            "Formation [idFormation=" +
            idFormation +
            ", reference=" +
            reference +
            ", titref=" +
            titref +
            ", lieu=" +
            lieu +
            ", interFormation=" +
            interFormation +
            ", duree=" +
            duree +
            ", prerequis=" +
            prerequis +
            ", objectif=" +
            objectif +
            ", publicVise=" +
            publicVise +
            ", programmeDetaille=" +
            programmeDetaille +
            "]"
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            duree,
            idFormation,
            interFormation,
            lieu,
            objectif,
            prerequis,
            programmeDetaille,
            publicVise,
            reference,
            titref
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Formation other = (Formation) obj;
        return (
            duree == other.duree &&
            idFormation == other.idFormation &&
            Objects.equals(interFormation, other.interFormation) &&
            Objects.equals(lieu, other.lieu) &&
            Objects.equals(objectif, other.objectif) &&
            Objects.equals(prerequis, other.prerequis) &&
            Objects.equals(programmeDetaille, other.programmeDetaille) &&
            Objects.equals(publicVise, other.publicVise) &&
            Objects.equals(reference, other.reference) &&
            Objects.equals(titref, other.titref)
        );
    }
}
