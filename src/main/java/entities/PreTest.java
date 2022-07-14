package entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class PreTest {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTest;
	private String titre;
	
	public PreTest() {
		// TODO Auto-generated constructor stub
	}

	public PreTest(long idTest, String titre) {
		
		this.idTest = idTest;
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

	
	}


