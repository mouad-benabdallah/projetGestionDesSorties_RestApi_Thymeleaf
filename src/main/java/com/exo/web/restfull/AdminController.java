package com.exo.web.restfull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exo.entities.Admin;
import com.exo.entities.Role;
import com.exo.repository.RoleRepository;
import com.exo.service.AccountService;

@RestController
@RequestMapping("api/admins")
public class AdminController {
	@Autowired
	AccountService accountService;
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("")
	public List<Admin> admins(){
		return accountService.admins();
	}
	@PostMapping
	public void addadmin(@RequestBody Admin admin) {
		accountService.saveAdmin(admin);
	}
	@PostMapping("/{rolename}")
	public void addSortie(@PathVariable String rolename,@RequestBody Admin admin)
	{
		
		Role role=roleRepository.findByRoleName(rolename);
		admin.getRoles().add(role);
		accountService.saveAdmin(admin);
	}

}
