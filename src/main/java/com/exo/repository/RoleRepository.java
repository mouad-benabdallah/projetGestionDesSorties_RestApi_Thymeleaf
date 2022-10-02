package com.exo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exo.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
	public Role findByRoleName(String roleName);

}
