package com.example.demo.Entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PubliScientEntity {

	@Id
	private Long idPubli;
	@Column(length = 40)
	private String Auteur;
	@Column(length = 100)
	private String sujet ;
	@Column(length = 100)
	private String doc;
	private Date datePubli;
	
	
	public PubliScientEntity() {
		super();
	}
	public PubliScientEntity(String auteur, String sujet, String doc, Date datePubli) {
		super();
		Auteur = auteur;
		this.sujet = sujet;
		this.doc = doc;
		this.datePubli = datePubli;
	}
	public Long getIdPubli() {
		return idPubli;
	}
	public void setIdPubli(Long idPubli) {
		this.idPubli = idPubli;
	}
	public String getAuteur() {
		return Auteur;
	}
	public void setAuteur(String auteur) {
		Auteur = auteur;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	public Date getDatePubli() {
		return datePubli;
	}
	public void setDatePubli(Date datePubli) {
		this.datePubli = datePubli;
	} 
	
	
	
}
