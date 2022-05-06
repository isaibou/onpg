package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Tableau;

public interface TabRepository extends JpaRepository<Tableau, Long> {

}
