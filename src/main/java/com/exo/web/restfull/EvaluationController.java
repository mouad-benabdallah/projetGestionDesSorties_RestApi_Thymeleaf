package com.exo.web.restfull;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exo.entities.Evaluation;
import com.exo.service.EvaluationService;

@RestController
@RequestMapping("api/evaluation")
public class EvaluationController {
	@Autowired
	EvaluationService evaluationService;
	
	@GetMapping("")
	public Page<Evaluation> trinotdesc(Pageable pageable){
		return evaluationService.findAllByOrderByNoteDesc(pageable);
	}
	@PostMapping
	public void addevaluation(@RequestBody @Valid Evaluation e) {
		evaluationService.addevaluation(e);
	}
	@DeleteMapping("/delete/{id}")
	public void deletebyid(@PathVariable int id) {
		evaluationService.deletebyid(id);
	}
	@GetMapping("/findall")
	public Page<Evaluation> findall(Pageable pageable){
		return evaluationService.findAll(pageable);
	}
	

}
