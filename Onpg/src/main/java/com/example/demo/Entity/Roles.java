package com.example.demo.Entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Roles {
	
	@Id
	@Column(length = 20)
	private String role;
	@Column(length = 50)
	private String description;
	
	
	
	public Roles() {
		super();
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Roles(String role, String description) {
		super();
		this.role = role;
		this.description = description;
	}

	
	
}
