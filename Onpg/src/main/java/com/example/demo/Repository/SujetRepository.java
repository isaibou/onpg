package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Sujet;

public interface SujetRepository extends JpaRepository<Sujet, Long> {

}
