package com.saturne.redwire.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "evalSessions")
public class EvalSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEval")
    private long idEval;

    @Column(name = "pedagogy")
    private int pedagogie;

    @Column(name = "fieldMastery")
    private int maitrisedomaine;

    @Column(name = "availibility")
    private int disponibilite;

    @Column(name = "questionsResponse")
    private int reponsesQuestions;

    @Column(name = "recommandation")
    private boolean recommandation;

    @OneToOne
    @JoinColumn(name = "idTrainer")
    private Formateur evalFormateur;

    @OneToOne
    @JoinColumn(name = "idTraining")
    private Formation evalContenu;

    public EvalSession() {}

    public EvalSession(int pedagogie, int maitrisedomaine, int disponibilite, int reponsesQuestions, boolean recommandation) {
        this.pedagogie = pedagogie;
        this.maitrisedomaine = maitrisedomaine;
        this.disponibilite = disponibilite;
        this.reponsesQuestions = reponsesQuestions;
        this.recommandation = recommandation;
    }

    public EvalSession(long idEval, int pedagogie, int maitrisedomaine, int disponibilite, int reponsesQuestions, boolean recommandation) {
        this.idEval = idEval;
        this.pedagogie = pedagogie;
        this.maitrisedomaine = maitrisedomaine;
        this.disponibilite = disponibilite;
        this.reponsesQuestions = reponsesQuestions;
        this.recommandation = recommandation;
    }

    @Override
    public String toString() {
        return (
            "EvalSession [idEval=" +
            idEval +
            ", pedagogie=" +
            pedagogie +
            ", maitrisedomaine=" +
            maitrisedomaine +
            ", disponibilite=" +
            disponibilite +
            ", reponsesQuestions=" +
            reponsesQuestions +
            ", recommandation=" +
            recommandation +
            "]"
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(disponibilite, idEval, maitrisedomaine, pedagogie, recommandation, reponsesQuestions);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        EvalSession other = (EvalSession) obj;
        return (
            disponibilite == other.disponibilite &&
            idEval == other.idEval &&
            maitrisedomaine == other.maitrisedomaine &&
            pedagogie == other.pedagogie &&
            recommandation == other.recommandation &&
            reponsesQuestions == other.reponsesQuestions
        );
    }
}
