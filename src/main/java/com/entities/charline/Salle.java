package com.entities.charline;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.entities.jeanmanno.Session;

//STATUS: NOT-TESTED

@Entity
@Table(name="classrooms")
public class Salle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idClassroom")
	private long idSalle;

	@Column(name="floor")
	private int etage;

	@Column(name="address")
	private String adresse;

	@OneToMany(mappedBy="salle")
	private Set<Session> sessions = new HashSet<Session>();

	public Salle() {}
	public Salle(int etage, String adresse) {
		this.etage = etage;
		this.adresse = adresse;
	}

	// idSalle ~ No SETTER -> AUTO-INCREMENTED VALUE
	public long getIdSalle() {
		return idSalle;
	}

	// etage
	public int getEtage() {
		return etage;
	}
	public void setEtage(int etage) {
		this.etage = etage;
	}

	// adresse
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	// sessions
	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Salle [idSalle=" + idSalle + ", etage=" + etage + ", adresse=" + adresse + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresse, etage, idSalle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salle other = (Salle) obj;
		return Objects.equals(adresse, other.adresse) && etage == other.etage && Objects.equals(idSalle, other.idSalle);
	}
}
