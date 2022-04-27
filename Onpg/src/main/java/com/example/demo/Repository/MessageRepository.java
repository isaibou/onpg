package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Message;

public interface MessageRepository  extends JpaRepository<Message, Long> {

	public List<Message> findByIsDone(Boolean isdone);
}
