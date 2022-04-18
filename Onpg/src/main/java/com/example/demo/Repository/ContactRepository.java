package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Contact;

public interface ContactRepository  extends JpaRepository<Contact, Long> {

	public List<Contact> findByIsDone(Boolean isdone);
}
