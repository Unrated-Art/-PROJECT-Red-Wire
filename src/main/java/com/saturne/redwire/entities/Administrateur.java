package com.saturne.redwire.entities;

import com.saturne.redwire.enumerations.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrateur extends User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idAdmin")
  private long idAdmin;

  @Column(name = "lastName")
  private String nom;

  @Column(name = "firstName")
  private String prenom;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String mpass;

  @Enumerated(EnumType.STRING)
  @Column(name = "user_role")
  private Role role;

  public Administrateur() {}

  public Administrateur(String nom, String prenom, String email, String mpass) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.mpass = mpass;
    this.role = Role.ADMIN;
  }

  public long getIdAdmin() {
    return idAdmin;
  }

  public void setIdAdmin(long idAdmin) {
    this.idAdmin = idAdmin;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMpass() {
    return mpass;
  }

  public void setMpass(String mpass) {
    this.mpass = mpass;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return (
      "Administrateur [idAdmin=" +
      idAdmin +
      ", nom=" +
      nom +
      ", prenom=" +
      prenom +
      ", email=" +
      email +
      ", mpass=" +
      mpass +
      ", role=" +
      role +
      "]"
    );
  }
}
