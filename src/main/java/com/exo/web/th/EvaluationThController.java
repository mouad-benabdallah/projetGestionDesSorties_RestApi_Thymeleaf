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

import com.exo.entities.Evaluation;
import com.exo.service.EvaluationService;

@Controller
@RequestMapping("evaluation")
public class EvaluationThController {
	@Autowired
	EvaluationService evaluationService;
	
	@GetMapping("")
	public String evaluations(Model m,Pageable pageable) {
		Page<Evaluation> list = evaluationService.findAll(pageable);
		Evaluation evaluation = new Evaluation();
		m.addAttribute("evaluation", evaluation);
		m.addAttribute("evaluations", list);
		return "evaluation";
	}
	@PostMapping("/add")
	public String addevaluation(@Valid Evaluation evaluation,BindingResult result) {
		if(result.hasErrors())
		{
			return "evaluation";
		}
		else
		{
		evaluationService.addevaluation(evaluation);
		return "redirect:/evaluation";
		}
	}
	@GetMapping("/liste")
	public String listevaluation(Model m,Pageable pageable) {
		Page<Evaluation> list = evaluationService.findAll(pageable);
		m.addAttribute("evaluations", list);
		return "listevaluation";
	}
	@RequestMapping(value = "/delete/{id}",method = {RequestMethod.GET,RequestMethod.DELETE})
	public String delete(@PathVariable int id) {
		evaluationService.deletebyid(id);
		return "redirect:/evaluation";
	}

}
