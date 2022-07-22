package com.entities.nourhene;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.entities.patrick.PreTest;

//STATUS: NOT-TESTED

@Entity
@Table(name="questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idQuestion")
	private long idQuestion;

	@Column(name="content")
	private String contenuQ;

	@Column(name="idTheme")
	private long idTheme;

    @ManyToMany(mappedBy="questions")
	private Set<PreTest> preTests = new HashSet<PreTest>();

	public Question() {}
	public Question(String contenuQ, long idTheme) {
		this.contenuQ = contenuQ;
		this.idTheme = idTheme;
	}

	// idQuestion ~ No SETTER -> AUTO-INCREMENTED VALUE
	public long getIdQuestion() {
		return idQuestion;
	}

	// content
	public String getContenuQ() {
		return contenuQ;
	}
	public void setContenuQ(String contenuQ) {
		this.contenuQ = contenuQ;
	}

	// idTheme
	public long getIdTheme() {
		return idTheme;
	}
	public void setIdTheme(long idTheme) {
		this.idTheme = idTheme;
	}

	@Override
	public String toString() {
		return "Question [idQuestion=" + idQuestion + ", contenuQ=" + contenuQ + ", idTheme=" + idTheme + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contenuQ, idQuestion, idTheme, preTests);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(contenuQ, other.contenuQ) && idQuestion == other.idQuestion && idTheme == other.idTheme
				&& Objects.equals(preTests, other.preTests);
	}
}
