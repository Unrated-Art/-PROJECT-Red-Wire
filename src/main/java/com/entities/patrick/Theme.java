package com.entities.patrick;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//STATUS: NOT-TESTED

@Entity
@Table(name="themes")
public class Theme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idTheme")
	private long idTheme;

    @Column(name="themeName")
    private String nom;

	@ManyToMany(mappedBy="sousTheme")
	@JoinTable(
		name="theme_structure",
		joinColumns={@JoinColumn(name="idParent")}, 
        inverseJoinColumns={@JoinColumn(name="idTheme")}
	)
	private Set<Theme> parentTheme = new HashSet<Theme>();

	@ManyToMany()
	@JoinTable(
		name="theme_structure", 
        joinColumns={@JoinColumn(name="idTheme")}, 
        inverseJoinColumns={@JoinColumn(name="idParent")}
	)

	private Set<Theme> sousTheme = new HashSet<Theme>();
    
	public Theme() {}
	public Theme(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Theme [idTheme=" + idTheme + ", nom=" + nom + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTheme, nom, parentTheme, sousTheme);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theme other = (Theme) obj;
		return idTheme == other.idTheme && Objects.equals(nom, other.nom)
				&& Objects.equals(parentTheme, other.parentTheme) && Objects.equals(sousTheme, other.sousTheme);
	}
}
