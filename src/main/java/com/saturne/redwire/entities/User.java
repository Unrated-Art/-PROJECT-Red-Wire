package com.saturne.redwire.entities;

import com.saturne.redwire.enumerations.Role;

public class User {

  private String nom;
  private String prenom;
  private String email;
  private Role role;

  public User() {}

  public User(String nom, String prenom, String email, Role role) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.role = role;
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

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "User [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", role=" + role + "]";
  }
}
