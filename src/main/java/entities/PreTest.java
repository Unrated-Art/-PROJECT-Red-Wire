package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="") // translate to plurial in english
public class PreTest {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTest")
	private long idTest;

	@Column(name="")
	private String titre;
	
	public PreTest() {}

	public PreTest(String titre) {
		this.titre = titre;
	}

	public long getIdTest() {
		return idTest;
	}

	public void setIdTest(long idTest) {
		this.idTest = idTest;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "PreTest [idTest=" + idTest + ", titre=" + titre + "]";
	}

	// Relation entre PreTest + Question
	// Many To Many
}


