package com.exo.web.th;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exo.entities.Admin;
import com.exo.entities.Role;
import com.exo.repository.AdminRepository;
import com.exo.repository.RoleRepository;
import com.exo.service.AccountService;

@Controller
@RequestMapping("admin")
public class AdminThController {
	@Autowired
	AccountService accountService;
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("")
	public String admin(Model m ) {
		
		List<Admin> admins= adminRepository.findAll();
		m.addAttribute("admins", admins);
		Admin ad = new Admin();
		m.addAttribute("admin", ad);
		return "addadmin.html";
		
	}
	@PostMapping("/add")
	public String addadmin(@Valid Admin admin,BindingResult result) {
		if(result.hasErrors())
		{
			return "addadmin.html";
		}
		else
		{
		
		Role role=roleRepository.findByRoleName("user");
		admin.getRoles().add(role);
		admin.setActive(1);
		accountService.saveAdmin(admin);
		return"redirect:/login";
		}
	}
	@GetMapping("list")
	public String alladmin(Model m ,Pageable pageable) {
		List<Role> roles=roleRepository.findAll();
		Page<Admin> admins= accountService.findAll(pageable);
		Role rol=new Role(); 
		m.addAttribute("role",rol);
		m.addAttribute("roles", roles);
		m.addAttribute("admins", admins);
		return "listadmin.html";
	}
	@PostMapping("/addrole")
	public String addrole(Admin admin,@RequestParam String rol,@RequestParam String admins) {
		accountService.addRoleToAdmin(admins, rol);
		return "redirect:/admin/list";
		
	}
	
	@RequestMapping(value = "/delete/{login}",method = {RequestMethod.GET,RequestMethod.DELETE})
	public String delete(@PathVariable String login) {
		accountService.deletebylogin(login);
		return "redirect:/admin/list";
	}

}
