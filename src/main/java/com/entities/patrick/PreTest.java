package com.entities.patrick;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.entities.nourhene.Question;

//STATUS: NOT-TESTED

@Entity
@Table(name="preTests")
public class PreTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idTest")
	private long idTest;

	@Column(name="title")
	private String titre;

    @ManyToMany()
    @JoinTable(
		name="tests_questions",
		joinColumns={ @JoinColumn(name="idTest", referencedColumnName="idTest") },
		inverseJoinColumns={ @JoinColumn(name="idQuestion", referencedColumnName="idQuestion") }
    )
	private Set<Question> questions = new HashSet<Question>();

	public PreTest() {}
	public PreTest(String titre) {
		this.titre = titre;
	}

	// idTest ~ No SETTER -> AUTO-INCREMENTED VALUE
	public long getIdTest() {
		return idTest;
	}

	// titre
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

	@Override
	public int hashCode() {
		return Objects.hash(idTest, questions, titre);
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
		return idTest == other.idTest && Objects.equals(questions, other.questions)
				&& Objects.equals(titre, other.titre);
	}
}
