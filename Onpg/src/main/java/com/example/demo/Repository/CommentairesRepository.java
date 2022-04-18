package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Commentaires;
import com.example.demo.Entity.Sujet;

public interface CommentairesRepository extends JpaRepository<Commentaires, Long> {
	
	public List<Commentaires> findBySujets(Sujet sujet);

}
