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
import com.exo.entities.Sortie;
import com.exo.repository.AdminRepository;
import com.exo.service.AccountService;
import com.exo.service.SortieService;

@Controller
@RequestMapping("sortie")
public class SortieThController {
	@Autowired
	SortieService sortieService;
	@Autowired
	AccountService accountService;
	@Autowired
	AdminRepository adminRepository;
	
	
	@GetMapping("")
	public String sorties(Model m,Pageable pageable) {
		Page<Sortie> list = sortieService.readall(pageable);
		Sortie sortie = new Sortie();
		List<Admin> admins= adminRepository.findAll();
		m.addAttribute("admins", admins);
		m.addAttribute("sortie", sortie);
		m.addAttribute("sorties", list);
		String nom=""; // initialisation de nomcomplet d'admin
		m.addAttribute("nom",nom);
		return "sortie";
	}
	@PostMapping("/add")
	public String addsortie(@Valid Sortie sortie,BindingResult result,@RequestParam String nom) {
		if(result.hasErrors())
		{
			return "sortie";
		}
		else
		{
		Admin a = accountService.findByNomComplet(nom);
		sortie.setAdmin(a);
		sortieService.addsortie(sortie);
		return "redirect:/sortie";
		}
	}
	@GetMapping("/liste")
	public String listsortie(Model m,Pageable pageable) {
		Page<Sortie> list = sortieService.readall(pageable);
		m.addAttribute("sorties", list);
		return "listsortie";
	}
	@RequestMapping(value = "/delete/{id}",method = {RequestMethod.GET,RequestMethod.DELETE})
	public String delete(@PathVariable int id) {
		sortieService.deletebyid(id);
		return "redirect:/sortie";
	}

}
