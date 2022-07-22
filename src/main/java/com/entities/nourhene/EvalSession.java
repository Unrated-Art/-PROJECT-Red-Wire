package com.entities.nourhene;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.entities.jeanmanno.Stagiaire;

//STATUS: NOT-TESTED

@Entity
@Table(name="evaluations")
public class EvalSession {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idEvaluation")
	private long idEval;

	@Column(name="evalTrainer")
	private int evalFormateur;

	@Column(name="evalContent")
	private int evalContenu;
	
	@Column(name="pedagogy")
	private int pedagogie;

	@Column(name="fieldMastery")
	private int maitrisedomaine;

	@Column(name="availibility")
	private int disponibilite;

	@Column(name="questionsResponse")
	private int reponsesQuestions;

	@Column(name="recommandation")
	private boolean recommandation;

	@ManyToOne()
	@JoinColumn(name="idTrainee")
	private Stagiaire stagiaire;

	public EvalSession() {}
	public EvalSession(int evalFormateur, int evalContenu, int pedagogie, int maitrisedomaine, int disponibilite,
			int reponsesQuestions, boolean recommandation) {
		this.evalFormateur = evalFormateur;
		this.evalContenu = evalContenu;
		this.pedagogie = pedagogie;
		this.maitrisedomaine = maitrisedomaine;
		this.disponibilite = disponibilite;
		this.reponsesQuestions = reponsesQuestions;
		this.recommandation = recommandation;
	}

	// idEval ~ No SETTER -> AUTO-INCREMENTED VALUE
	public long getIdEval() {
		return idEval;
	}

	// evalFormateur
	public int getEvalFormateur() {
		return evalFormateur;
	}
	public void setEvalFormateur(int evalFormateur) {
		this.evalFormateur = evalFormateur;
	}

	// evalContenu
	public int getEvalContenu() {
		return evalContenu;
	}
	public void setEvalContenu(int evalContenu) {
		this.evalContenu = evalContenu;
	}

	// pedagogie
	public int getPedagogie() {
		return pedagogie;
	}
	public void setPedagogie(int pedagogie) {
		this.pedagogie = pedagogie;
	}

	// maitrisedomaine
	public int getMaitrisedomaine() {
		return maitrisedomaine;
	}
	public void setMaitrisedomaine(int maitrisedomaine) {
		this.maitrisedomaine = maitrisedomaine;
	}

	// disponibilite
	public int getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(int disponibilite) {
		this.disponibilite = disponibilite;
	}

	// reponsesQuestions
	public int getReponsesQuestions() {
		return reponsesQuestions;
	}
	public void setReponsesQuestions(int reponsesQuestions) {
		this.reponsesQuestions = reponsesQuestions;
	}

	// recommendation
	public boolean isRecommandation() {
		return recommandation;
	}
	public void setRecommandation(boolean recommandation) {
		this.recommandation = recommandation;
	}

	// stagiaire
	public Stagiaire getStagiaire() {
		return stagiaire;
	}
	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	@Override
	public String toString() {
		return "EvalSession [idEval=" + idEval + ", evalFormateur=" + evalFormateur + ", evalContenu=" + evalContenu
				+ ", pedagogie=" + pedagogie + ", maitrisedomaine=" + maitrisedomaine + ", disponibilite="
				+ disponibilite + ", reponsesQuestions=" + reponsesQuestions + ", recommandation=" + recommandation
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(disponibilite, evalContenu, evalFormateur, idEval, maitrisedomaine, pedagogie,
				recommandation, reponsesQuestions, stagiaire);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvalSession other = (EvalSession) obj;
		return disponibilite == other.disponibilite && evalContenu == other.evalContenu
				&& evalFormateur == other.evalFormateur && idEval == other.idEval
				&& maitrisedomaine == other.maitrisedomaine && pedagogie == other.pedagogie
				&& recommandation == other.recommandation && reponsesQuestions == other.reponsesQuestions
				&& Objects.equals(stagiaire, other.stagiaire);
	}
}
