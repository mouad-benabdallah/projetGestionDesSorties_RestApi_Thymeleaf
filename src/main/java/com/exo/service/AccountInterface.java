package com.exo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.exo.entities.Admin;
import com.exo.entities.Role;

public interface AccountInterface {
	public Admin saveAdmin(Admin admin);
	public Role saveRole(Role role);
	public void addRoleToAdmin(String login, String roleName);
	public Admin findByLogin(String login);
	public Admin findByNomComplet(String nomComplet);
	public List<Admin> admins();
	public Page<Admin> findAll(Pageable pageable);
	public void deletebylogin(String login);

}
