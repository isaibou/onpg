package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {

}
