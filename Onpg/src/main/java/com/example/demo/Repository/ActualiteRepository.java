package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Actualite;

public interface ActualiteRepository extends JpaRepository<Actualite, Long> {
	

}
