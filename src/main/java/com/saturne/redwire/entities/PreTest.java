package com.saturne.redwire.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "preTests")
public class PreTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTest")
    private long idTest;

    @Column(name = "title")
    private String titre;

    public PreTest() {}

    public PreTest(String titre) {
        this.titre = titre;
    }

    public PreTest(long idTest, String titre) {
        this.idTest = idTest;
        this.titre = titre;
    }

    public long getIdTest() {
        return idTest;
    }

    public void setIdTest(long idTest) {
        this.idTest = idTest;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "PreTest [idTest=" + idTest + ", titre=" + titre + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTest, titre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PreTest other = (PreTest) obj;
        return idTest == other.idTest && Objects.equals(titre, other.titre);
    }
}
