package com.exo.web.th;



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

import com.exo.entities.Recommandation;
import com.exo.repository.RecommandationRepository;
import com.exo.service.RecommandationService;

@Controller
@RequestMapping("recommandation")
public class RecommandationThController {
	@Autowired
	RecommandationService recommandationService;
	@Autowired
	RecommandationRepository recommandationRepository;
	
	@GetMapping("")
	public String recommandations(Model m,Pageable pageable) {
		Page<Recommandation> list = recommandationService.findall(pageable);
		Recommandation recommandation = new Recommandation();
		m.addAttribute("recommandation", recommandation);
		m.addAttribute("recommandations", list);
		return "recommandation";
	}
	@PostMapping("/add")
	public String addrecommandation(@Valid Recommandation recommandation,BindingResult result) {
		if(result.hasErrors())
		{
			return "recommandation";
		}
		else
		{
		recommandationService.addrecommandation(recommandation);
		return "redirect:/recommandation";
		}
	}
	@GetMapping("/liste")
	public String listrecommandation(Model m,Pageable pageable) {
		Page<Recommandation> list = recommandationService.findall(pageable);
		m.addAttribute("recommandations", list);
		return "listrecommandation";
	}
	@RequestMapping(value = "/delete/{id}",method = {RequestMethod.GET,RequestMethod.DELETE})
	public String delete(@PathVariable int id) {
		recommandationService.deletebyid(id);
		return "redirect:/recommandation";
	}

}
