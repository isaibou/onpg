package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class refAM {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRef;

	public refAM() {
		super();
	}

	public Long getIdRef() {
		return idRef;
	}

	public void setIdRef(Long idRef) {
		this.idRef = idRef;
	}
	
	 
}
