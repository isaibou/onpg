package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

	List<Users> findByIsNew(Boolean isNew);
}
