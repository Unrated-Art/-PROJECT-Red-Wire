package com.entities.nourhene;

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
@Table(name="trainers")
public class Formateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idTrainer")
	private long idFormateur;

    @Column(name="cv")
    private String cv;

    @OneToMany(mappedBy="formateur")
    private Set<Session> sessions = new HashSet<Session>();

	public Formateur() {}
	public Formateur(String cv) {
		this.cv = cv;
	}

	// idFormateur ~ No SETTER -> AUTO-INCREMENTED VALUE
	public long getIdFormateur() {
		return idFormateur;
	}

	// cv
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
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
		return "Formateur [idFormateur=" + idFormateur + ", cv=" + cv + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cv, idFormateur, sessions);
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
		return Objects.equals(cv, other.cv) && idFormateur == other.idFormateur
				&& Objects.equals(sessions, other.sessions);
	}
}
