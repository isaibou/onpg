package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

}
