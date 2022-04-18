package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TexteReglemantaire {

	@Id
	@GeneratedValue
	private Long id;
	private String texte;
	private String path;
	private String fileName;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
}
