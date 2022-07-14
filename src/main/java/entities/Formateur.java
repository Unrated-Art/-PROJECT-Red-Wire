package entities;

import java.util.HashSet;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="")
public class Formateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="")
	private long idFormateur;

    @Column(name="")
    private String cv;

    // One To Many
	//référence vers sessions : 1 formateur peut participer à plusieurs sessions de formation=> collection de sessions dans Formateur
	private HashSet<Session> listeSessions= new HashSet<Session>(); //la liste des sessions auxqeulles il participe

	public Formateur() {}

	public Formateur(String cv) {
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

	public HashSet<Session> getListeSessions() {
		return listeSessions;
	}

	public void setListeSessions(HashSet<Session> listeSessions) {
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
