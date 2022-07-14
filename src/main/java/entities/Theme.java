package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="")
public class Theme {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="")
	private long idTheme;

    @Column(name="")
    private String nomTheme;
	
	//1 theme peut avoir plusieurs sous-themes
    // !#TODO: Generate EQUALS + HASHCODE upon use of HashSet
    @Column(name="")
	private Set<Theme> sousTheme = new HashSet<Theme>();
	
	public Theme() {}

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

}
