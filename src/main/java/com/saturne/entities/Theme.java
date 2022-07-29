package com.saturne.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="themes")
public class Theme {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTheme")
	private long idTheme;

    @Column(name="themeName")
    private String nomTheme;
	
	
    // !#TODO: Generate EQUALS + HASHCODE upon use of HashSet!!!
    //1 theme <--> * sous-themes
    @OneToMany/*(cascade=CascadeType.PERSIST)*/ //#!TODO: check cascade Type!!
	private Set<Theme> sousTheme = new HashSet<Theme>();
	
	public Theme() {}
	


	//constructeur
	public Theme(String nomTheme) {
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

	public Set<Theme> getSousTheme() {
		return sousTheme;
	}

	public void setSousTheme(Set<Theme> sousTheme) {
		this.sousTheme = sousTheme;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theme other = (Theme) obj;
		return idTheme == other.idTheme && Objects.equals(nomTheme, other.nomTheme)
				//&& Objects.equals(sousTheme, other.sousTheme)
				;
	}
	
	
	

}
