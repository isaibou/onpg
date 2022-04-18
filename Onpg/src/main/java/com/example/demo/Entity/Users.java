package com.example.demo.Entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Users {

	@Id
	private String email;
	@Column(length = 50)
	private String nom;
	@Column(length = 50)
	private String prenom;
	
	private String mdp;
	
	private Boolean actived;
	
	private Boolean isNew;
	@ManyToMany
	private Collection<Roles> roles;
	
	@OneToMany(mappedBy = "users")
	private Collection<Commentaires> comments;
	@OneToMany(mappedBy = "users")
	private Collection<Sujet> sujets;
	@OneToMany(mappedBy = "users")
	private Collection<Paiement> paiement;
	@OneToMany(mappedBy = "users")
	private Collection<PubliScientEntity> publications;
	
	public Users() {
		
	}
	
	
	public Users(String email, String nom, String prenom, String mdp, Collection<Roles> roles) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
		this.roles = roles;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public Collection<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}


	public Boolean getActived() {
		return actived;
	}


	public void setActived(Boolean actived) {
		this.actived = actived;
	}


	public Boolean getIsNew() {
		return isNew;
	}


	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}


	public Collection<Commentaires> getComments() {
		return comments;
	}


	public void setComments(Collection<Commentaires> comments) {
		this.comments = comments;
	}


	public Collection<Sujet> getSujets() {
		return sujets;
	}


	public void setSujets(Collection<Sujet> sujets) {
		this.sujets = sujets;
	}


	public Collection<Paiement> getPaiement() {
		return paiement;
	}


	public void setPaiement(Collection<Paiement> paiement) {
		this.paiement = paiement;
	}
	
	
}
