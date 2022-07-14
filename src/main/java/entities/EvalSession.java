package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="EvaluationsSession")
public class EvalSession {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEval;
	
	private int evalFormateur; //=>  formateur
	private int evalContenu; //=> formation
	private int pedagogie; // =>formateur
	private int maitrisedomaine; // => formateur
	private int disponibilite; // =>formateur 
	private int reponsesAuxQ; //réponses aux questions =>formateur
	private boolean recommand; //=> recommandation de la formation
	
	//référence vers stagiaire : 1 évaluationSession concerne 1 et 1 seul stagiaire=>référence simple de stagiaire dans EvalSession
	//@ManyToOne(cascade=CascadeType.ALL, mappedBy="contact")
	private Stagiaire trainee;
	
	
	public EvalSession() {
		// TODO Auto-generated constructor stub
	}


	public EvalSession(int evalFormateur, int evalContenu, int pedagogie, int maitrisedomaine, int disponibilite,
			int reponsesAuxQ, boolean recommand) {
		super();
		this.evalFormateur = evalFormateur;
		this.evalContenu = evalContenu;
		this.pedagogie = pedagogie;
		this.maitrisedomaine = maitrisedomaine;
		this.disponibilite = disponibilite;
		this.reponsesAuxQ = reponsesAuxQ;
		this.recommand = recommand;
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


	public int getReponsesAuxQ() {
		return reponsesAuxQ;
	}


	public void setReponsesAuxQ(int reponsesAuxQ) {
		this.reponsesAuxQ = reponsesAuxQ;
	}


	public boolean isRecommand() {
		return recommand;
	}


	public void setRecommand(boolean recommand) {
		this.recommand = recommand;
	}

	
	
	//getter/setter pour la référence de stagiaire

	public Stagiaire getTrainee() {
		return trainee;
	}


	public void setTrainee(Stagiaire trainee) {
		this.trainee = trainee;
	}

	@Override
	public String toString() {
		return "EvalSession [evalFormateur=" + evalFormateur + ", evalContenu=" + evalContenu + ", pedagogie="
				+ pedagogie + ", maitrisedomaine=" + maitrisedomaine + ", disponibilite=" + disponibilite
				+ ", reponsesAuxQ=" + reponsesAuxQ + ", recommand=" + recommand + "]";
	}


	
	
	

}
