package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="") // translate to plurial in english
public class Question {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCatalogue")
	private long idQuestion;

	@Column(name="")
	private String contenuQ;

	@Column(name="")
	private String idTheme; 

	public Question() {
		// TODO Auto-generated constructor stub
	}

	public Question(String contenuQ, String idTheme) {
		this.contenuQ = contenuQ;
		this.idTheme = idTheme;
	}

	public long getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(long idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getContenuQ() {
		return contenuQ;
	}

	public void setContenuQ(String contenuQ) {
		this.contenuQ = contenuQ;
	}

	public String getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(String idTheme) {
		this.idTheme = idTheme;
	}

	@Override
	public String toString() {
		return "Question [idQuestion=" + idQuestion + ", contenuQ=" + contenuQ + ", idTheme=" + idTheme + "]";
	}

	// Relation entre Question + PreTest
	// Many To Many
}
