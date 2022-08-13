package com.saturne.redwire.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idQuestion")
    private long idQuestion;

    @Column(name = "content")
    private String contenuQ;

    @ManyToOne
    @JoinColumn(name = "idTheme")
    private Theme idTheme;

    public Question() {}

    public Question(String contenuQ) {
        this.contenuQ = contenuQ;
    }

    public Question(long idQuestion, String contenuQ) {
        this.idQuestion = idQuestion;
        this.contenuQ = contenuQ;
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

    @Override
    public String toString() {
        return "Question [idQuestion=" + idQuestion + ", contenuQ=" + contenuQ + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(contenuQ, idQuestion);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Question other = (Question) obj;
        return Objects.equals(contenuQ, other.contenuQ) && idQuestion == other.idQuestion;
    }
}
