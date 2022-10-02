package com.exo.web.restfull;

import java.util.List;

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

import com.exo.entities.Participant;
import com.exo.service.ParticipantService;

@RestController
@RequestMapping("api/participant")
public class ParticipantController {
	@Autowired
	ParticipantService participantService;
	
	@GetMapping("")
	public Page<Participant> readparticipant(Pageable pageable){
		return participantService.findall(pageable);
	}
	@PostMapping
	public void addparticipant(@RequestBody @Valid Participant p) {
		participantService.addparticipent(p);
	}
	@DeleteMapping("/delete/{id}")
	public void deletebyid(@PathVariable int id) {
		participantService.deletebyid(id);
	}
	@GetMapping("searchAnd/{nom}/{prenom}")
	public List<Participant> findbynomandprenom(@PathVariable String nom,@PathVariable String prenom){
		return participantService.findByNomAndPrenom(nom, prenom);
	}
	@GetMapping("searchOr/{nom}/{prenom}")
	public List<Participant> findbynomorprenom(@PathVariable String nom,@PathVariable String prenom){
		return participantService.findByNomOrPrenom(nom, prenom);
	}
	@GetMapping("searchEmail/{email}")
	public Participant findbyemail(@PathVariable String email){
		return participantService.findByEmail(email);
	}
	

}
