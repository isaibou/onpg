package com.example.demo.Entity;


import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.Repository.CommentairesRepository;

/**
 * @author saibo
 *
 */
@Entity
public class Sujet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSujet;
	private  String intitule;
	private String titre;
	
	@OneToMany(mappedBy = "sujets")
	private Collection<Commentaires> comments;
	@ManyToOne
	private Users users;
	
	@DateTimeFormat(pattern= "yyyy-mm-dd")
	private Date date;
	
	public Long getIdSujet() {
		return idSujet;
	}
	public void setIdSujet(Long idSujet) {
		this.idSujet = idSujet;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public Collection<Commentaires> getComments() {
		return comments;
	}
	public void setComments(Collection<Commentaires> comments) {
		this.comments = comments;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
