package com.saturne.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "themes")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTheme")
    private long idTheme;

    @Column(name = "name")
    private String nomTheme;

    public Theme() {}

    public Theme(String nomTheme) {
        this.nomTheme = nomTheme;
    }

    public Theme(long idTheme, String nomTheme) {
        this.idTheme = idTheme;
        this.nomTheme = nomTheme;
    }

    public long getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(long idTheme) {
        this.idTheme = idTheme;
    }

    public String getNomTheme() {
        return nomTheme;
    }

    public void setNomTheme(String nomTheme) {
        this.nomTheme = nomTheme;
    }

    @Override
    public String toString() {
        return "Theme [idTheme=" + idTheme + ", nomTheme=" + nomTheme + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTheme, nomTheme);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Theme other = (Theme) obj;
        return idTheme == other.idTheme && Objects.equals(nomTheme, other.nomTheme);
    }
}
