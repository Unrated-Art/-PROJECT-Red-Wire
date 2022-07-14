package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Theme {
	
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTheme;
	private String nomTheme;
	
	//1 theme peut avoir plusieurs sous-themes
	private Set<Theme> sousTheme = new HashSet<Theme>();
	
	public Theme() {
		// TODO Auto-generated constructor stub
	}

	public Theme(long idTheme, String nomTheme) {
		super();
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
