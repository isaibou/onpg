package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, String> {

}
