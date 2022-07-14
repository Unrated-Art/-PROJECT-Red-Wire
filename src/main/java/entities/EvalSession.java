package entities;

import javax.persistence.Column;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="evalSession")
public class EvalSession {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="")
	private long idEval;
	
	@Column(name="")
	private int evalFormateur; //=>  formateur

	@Column(name="")
	private int evalContenu; //=> formation
	
	@Column(name="")
	private int pedagogie; // =>formateur

	@Column(name="")
	private int maitrisedomaine; // => formateur

	@Column(name="")
	private int disponibilite; // =>formateur 

	@Column(name="")
	private int reponsesQuestions; //réponses aux questions =>formateur

	@Column(name="")
	private boolean recommandation; //=> recommandation de la formation
	
	//référence vers stagiaire : 1 évaluationSession concerne 1 et 1 seul stagiaire=>référence simple de stagiaire dans EvalSession
	//@ManyToOne(cascade=CascadeType.ALL, mappedBy="contact")
	// !#TODO: A faire
	private Stagiaire trainee;
	
	public EvalSession() {}

	public EvalSession(int evalFormateur, int evalContenu, int pedagogie, int maitrisedomaine, int disponibilite,
			int reponsesQuestions, boolean recommandation, Stagiaire trainee) {
		this.evalFormateur = evalFormateur;
		this.evalContenu = evalContenu;
		this.pedagogie = pedagogie;
		this.maitrisedomaine = maitrisedomaine;
		this.disponibilite = disponibilite;
		this.reponsesQuestions = reponsesQuestions;
		this.recommandation = recommandation;
		this.trainee = trainee;
	}

	public int getEvalFormateur() {
		return evalFormateur;
	}


	public void setEvalFormateur(int evalFormateur) {
		this.evalFormateur = evalFormateur;
	}


	public int getEvalContenu() {
		return evalContenu;
	}


	public void setEvalContenu(int evalContenu) {
		this.evalContenu = evalContenu;
	}


	public int getPedagogie() {
		return pedagogie;
	}


	public void setPedagogie(int pedagogie) {
		this.pedagogie = pedagogie;
	}


	public int getMaitrisedomaine() {
		return maitrisedomaine;
	}


	public void setMaitrisedomaine(int maitrisedomaine) {
		this.maitrisedomaine = maitrisedomaine;
	}


	public int getDisponibilite() {
		return disponibilite;
	}


	public void setDisponibilite(int disponibilite) {
		this.disponibilite = disponibilite;
	}

	
	
	//getter/setter pour la référence de stagiaire

	public int getReponsesQuestions() {
		return reponsesQuestions;
	}

	public void setReponsesQuestions(int reponsesQuestions) {
		this.reponsesQuestions = reponsesQuestions;
	}

	public boolean isRecommandation() {
		return recommandation;
	}

	public void setRecommandation(boolean recommandation) {
		this.recommandation = recommandation;
	}

	public Stagiaire getTrainee() {
		return trainee;
	}


	public void setTrainee(Stagiaire trainee) {
		this.trainee = trainee;
	}

	@Override
	public String toString() {
		return "EvalSession [idEval=" + idEval + ", evalFormateur=" + evalFormateur + ", evalContenu=" + evalContenu
				+ ", pedagogie=" + pedagogie + ", maitrisedomaine=" + maitrisedomaine + ", disponibilite="
				+ disponibilite + ", reponsesQuestions=" + reponsesQuestions + ", recommandation=" + recommandation
				+ ", trainee=" + trainee + "]";
	}
}
