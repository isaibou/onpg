package com.example.demo.Entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Commentaires {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private  Long id;
	private String comments;
		

	@ManyToOne
	@JoinColumn(name="sujets_comments")
	private Sujet sujets ;
	
	
	
	@ManyToOne
	@JoinColumn(name="users_comments")
	private Users users;
	@DateTimeFormat(pattern= "yyyy-mm-dd")
	private Date date;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Sujet getSujets() {
		return sujets;
	}
	public void setSujets(Sujet sujets) {
		this.sujets = sujets;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
