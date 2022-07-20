package entities;

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

@Entity
@Table(name="")
public class Salle {

	@Id
	@Column(name="", nullable=false)
	private String idSalle;

	@Column(name="")
	private int etage;

	@Column(name="")
	private String adresse;
	
    // !#TODO: Generate EQUALS + HASHCODE upon use of HashSet
	// !#TODO: Creer -> accesseurs GET/SET
	@OneToMany(mappedBy="salle")
	
	
	
	private Set<Session> sessions = new HashSet<Session>();
	
	//Constructeur
	
	@Override
	public int hashCode() {
		return Objects.hash(adresse, etage, idSalle, sessions);
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
		return Objects.equals(adresse, other.adresse) && etage == other.etage && Objects.equals(idSalle, other.idSalle)
				&& Objects.equals(sessions, other.sessions);
	}

	public Salle(String idSalle, int etage, String adresse) {
		this.idSalle = idSalle;
		this.etage = etage;
		this.adresse = adresse;
	}

	public Salle() {}
	
	//Getter et Setter

	
	
	public String getIdSalle() {
		return idSalle;
	}

	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	public void setIdSalle(String idSalle) {
		this.idSalle = idSalle;
	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Salle [idSalle=" + idSalle + ", Etage=" + etage + ", adresse=" + adresse + "]";
	}
}
