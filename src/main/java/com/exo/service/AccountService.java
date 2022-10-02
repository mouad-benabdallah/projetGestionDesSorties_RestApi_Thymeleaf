package com.exo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exo.entities.Admin;
import com.exo.entities.Role;
import com.exo.repository.AdminRepository;
import com.exo.repository.RoleRepository;

@Service
@Transactional
public class AccountService implements AccountInterface{
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	RoleRepository roleRepository;
	
	@Bean
	public BCryptPasswordEncoder getBCPE()
	{
		return new BCryptPasswordEncoder();
		
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		String hashed=this.getBCPE().encode(admin.getPassword());
		admin.setPassword(hashed);
		return adminRepository.save(admin);
	}

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToAdmin(String login, String roleName) {
		// TODO Auto-generated method stub
		Role role=roleRepository.findByRoleName(roleName);
		Admin admin=adminRepository.findByLogin(login);
		admin.getRoles().add(role);
		
	}

	@Override
	public Admin findByLogin(String login) {
		// TODO Auto-generated method stub
		return adminRepository.findByLogin(login);
	}

	@Override
	public Admin findByNomComplet(String nomComplet) {
		// TODO Auto-generated method stub
		return adminRepository.findByNomComplet(nomComplet);
	}

	@Override
	public List<Admin> admins() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Page<Admin> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return adminRepository.findAll(pageable);
	}

	@Override
	public void deletebylogin(String login) {
		// TODO Auto-generated method stub
		adminRepository.deleteByLogin(login);
	}

}
