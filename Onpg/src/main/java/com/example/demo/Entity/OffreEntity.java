package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OffreEntity {
	
	@Id()
	private Long idOffre;
	@Column(length = 255)
	private String description;
	@Column(length = 10)
	private Long salaire;
	@Column(length = 50)
	private String entreprise;
	@Column(length = 30)
	private String disponibilite;
	
	public Long getIdOffre() {
		return idOffre;
		
	}
	
	
	
	public OffreEntity() {
		super();
	}



	public OffreEntity(String description, Long salaire, String entreprise, String disponibilite) {
		super();
		this.description = description;
		this.salaire = salaire;
		this.entreprise = entreprise;
		this.disponibilite = disponibilite;
	}


	public void setIdOffre(Long idOffre) {
		this.idOffre = idOffre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getSalaire() {
		return salaire;
	}
	public void setSalaire(Long salaire) {
		this.salaire = salaire;
	}
	public String getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	public String getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}

	
	
}
