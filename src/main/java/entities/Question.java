package entities;

public class Question {

	private long idQuestion;
	private String contenuQ;
	private String idTheme; 
	
	
	
	public Question() {
		// TODO Auto-generated constructor stub
	}

	public Question(long idQuestion, String contenuQ, String idTheme) {
		super();
		this.idQuestion = idQuestion;
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
	
	

}
