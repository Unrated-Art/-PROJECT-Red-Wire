package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Salle {
	
	@Id@Column(nullable=false)
	private String idSalle;
	private int etage;
	private String adresse;
	
	@OneToMany(mappedBy="salle")
	private Set<Session> sessions = new HashSet<Session>();
	
	//Constructeur
	
	public Salle(String idSalle, int etage, String adresse) {
		
		this.idSalle = idSalle;
		this.etage = etage;
		this.adresse = adresse;
	}

	
	public Salle() {
		
	}
	
	//Getter et Setter

	public String getIdSalle() {
		return idSalle;
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
