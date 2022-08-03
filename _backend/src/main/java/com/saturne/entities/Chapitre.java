package com.saturne.entities;

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
@Table(name = "chapters")
public class Chapitre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idChapter")
  private String idChap;

  @Column(name = "chapterName")
  private String nomChapitre;

  @Column(name = "chapterContent")
  private String contenu;

  //on ne peut pas utiliser "mappedby" avec une relation @manytoOne!! => OK avec @OneToMany
  //@ManyToOne(mappedBy="chapters")

  // !#TODO Update on errors
  // !#TODO: Generate EQUALS + HASHCODE upon use of HashSet
  @ManyToOne
  @JoinColumn(name = "idFormation") //version nourhene
  private Formation formation = new Formation(); //version nourhene

  //private Set<Formation> formations = new HashSet<Formation>(); //charline

  //Constructeur

  public Chapitre() {}

  public Chapitre(String idChap, String nomChapitre, String contenu) {
    this.idChap = idChap;
    this.nomChapitre = nomChapitre;
    this.contenu = contenu;
  }

  //Getter et Setter

  public String getIdChap() {
    return idChap;
  }

  public void setIdChap(String idChap) {
    this.idChap = idChap;
  }

  public String getNomChapitre() {
    return nomChapitre;
  }

  public void setNomChapitre(String nomChapitre) {
    this.nomChapitre = nomChapitre;
  }

  public String getContenu() {
    return contenu;
  }

  public void setContenu(String contenu) {
    this.contenu = contenu;
  }

  /**
   *
   * added by Nourhène
   */

  public Formation getFormation() {
    return formation;
  }

  public void setFormation(Formation formation) {
    this.formation = formation;
  }

  /**
   *
   * END added by Nourhène
   */

  @Override
  public String toString() {
    return (
      "Chapitre [idChap=" +
      idChap +
      ", nomChapitre=" +
      nomChapitre +
      ", Contenu=" +
      contenu +
      "]"
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(contenu, idChap, nomChapitre);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Chapitre other = (Chapitre) obj;
    return (
      Objects.equals(contenu, other.contenu) &&
      Objects.equals(idChap, other.idChap) &&
      Objects.equals(nomChapitre, other.nomChapitre)
    );
  }
  // Relation entre Chapitre + Formation
  // Many To One //Done By Nrhn

}
