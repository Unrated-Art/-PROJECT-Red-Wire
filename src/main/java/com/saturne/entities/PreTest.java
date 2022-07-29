package com.saturne.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="preTest") // translate to plurial in english
public class PreTest { //composite?

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTest")
	private long idTest;

	@Column(name="title")
	private String titre;
	
	
	// 1 pretset <--> * questions
	@OneToMany(mappedBy="idQuestion")
	private Set<Question> questions = new HashSet<Question>();
	
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

	
	
	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "PreTest [idTest=" + idTest + ", titre=" + titre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTest/*, questions*/, titre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PreTest other = (PreTest) obj;
		return idTest == other.idTest /*&& Objects.equals(questions, other.questions)*/
				&& Objects.equals(titre, other.titre);
	}
	
	
	
	

	// Relation entre PreTest + Question
	// Many To Many
}


