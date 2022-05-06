package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tableau {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTab;
	private String numInscrip;
	private String nomPrenom;
	private String structure;
	private String localite;
	private String grade;
	private String section;
	private double num;
	public Long getIdTab() {
		return idTab;
	}
	public void setIdTab(Long idTab) {
		this.idTab = idTab;
	}
	
	public void setNumInscrip(String string) {
		this.numInscrip = string;
	}
	public String getNomPrenom() {
		return nomPrenom;
	}
	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public String getLocalite() {
		return localite;
	}
	public void setLocalite(String localite) {
		this.localite = localite;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	
	
	
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
	}
	public String getNumInscrip() {
		return numInscrip;
	}
	
	
	
	
}
