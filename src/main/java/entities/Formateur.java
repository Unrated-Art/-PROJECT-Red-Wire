package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Formateur {

	
	private long idFormateur;
	private String cv;
	
	//référence vers sessions : 1 formateur peut participer à plusieurs sessions de formation=> collection de sessions dans Formateur
	private Set<Session> listeSessions= new HashSet<Session>(); //la liste des sessions auxqeulles il participe



	public Formateur() {
		// TODO Auto-generated constructor stub
	}

	public Formateur(long idFormateur, String cv) {
		super();
		this.idFormateur = idFormateur;
		this.cv = cv;
	}

	public long getIdFormateur() {
		return idFormateur;
	}

	public void setIdFormateur(long idFormateur) {
		this.idFormateur = idFormateur;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}
	
	
	
	public List<Session> getListeSessions() {
		return listeSessions;
	}

	public void setListeSessions(List<Session> listeSessions) {
		this.listeSessions = listeSessions;
	}

	@Override
	public String toString() {
		return "Formateur [idFormateur=" + idFormateur + ", cv=" + cv + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cv, idFormateur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formateur other = (Formateur) obj;
		return Objects.equals(cv, other.cv) && idFormateur == other.idFormateur;
	}
	
	
	

}
