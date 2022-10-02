package com.exo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exo.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	public Admin findByLogin(String login);
	public Admin findByNomComplet(String nomComplet);
	public void deleteByLogin(String login);
	
}
