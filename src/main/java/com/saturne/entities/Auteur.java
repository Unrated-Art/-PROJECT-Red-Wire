package com.saturne.entities;

public class Auteur {
	
	private long idAuteur;
	private String prenomA;
	private String nomA;
	

	public Auteur() {
		
	}


	public Auteur(long idAuteur, String prenomA, String nomA) {
		super();
		this.idAuteur = idAuteur;
		this.prenomA = prenomA;
		this.nomA = nomA;
	}


	public long getIdAuteur() {
		return idAuteur;
	}


	public void setIdAuteur(long idAuteur) {
		this.idAuteur = idAuteur;
	}


	public String getPrenomA() {
		return prenomA;
	}


	public void setPrenomA(String prenomA) {
		this.prenomA = prenomA;
	}


	public String getNomA() {
		return nomA;
	}


	public void setNomA(String nomA) {
		this.nomA = nomA;
	}


	@Override
	public String toString() {
		return "Auteur [idAuteur=" + idAuteur + ", prenomA=" + prenomA + ", nomA=" + nomA + "]";
	}
	
	

}
