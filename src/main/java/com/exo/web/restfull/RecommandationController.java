package com.exo.web.restfull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exo.entities.Recommandation;

import com.exo.service.RecommandationService;

@RestController
@RequestMapping("api/recommandation")
public class RecommandationController {
	@Autowired
	RecommandationService recommandationService;
	@GetMapping("")
	public Page<Recommandation> readall(Pageable pageable){
		return recommandationService.findall(pageable);
	}
	@PostMapping
	public void addrecom(@RequestBody Recommandation r) {
		recommandationService.addrecommandation(r);
	}

}
