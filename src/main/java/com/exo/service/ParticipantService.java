package com.exo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exo.entities.Participant;
import com.exo.entities.Sortie;
import com.exo.repository.ParticipantRepository;

@Service
public class ParticipantService implements ParticipantInterface{
	@Autowired
	ParticipantRepository participantRepository;
	@Autowired
	SortieService sortieService;

	@Override
	public Page<Participant> findall(Pageable pageable) {
		// TODO Auto-generated method stub
		return participantRepository.findAll(pageable);
	}

	@Override
	public Participant addparticipent(Participant participant) {
		// TODO Auto-generated method stub
		return participantRepository.save(participant);
	}

	@Override
	public void deletebyid(int id) {
		// TODO Auto-generated method stub
		participantRepository.deleteById(id);
	}

	@Override
	public Optional<Participant> findById(int id) {
		// TODO Auto-generated method stub
		return participantRepository.findById(id);
	}

	@Override
	public List<Participant> findByNomAndPrenom(String nom, String prenom) {
		// TODO Auto-generated method stub
		return participantRepository.findByNomAndPrenom(nom, prenom);
	}

	@Override
	public List<Participant> findByNomOrPrenom(String nom, String prenom) {
		// TODO Auto-generated method stub
		return participantRepository.findByNomOrPrenom(nom, prenom);
	}

	@Override
	public Participant findByEmail(String email) {
		// TODO Auto-generated method stub
		return participantRepository.findByEmail(email);
	}

	@Override
	public void addSortieToParticipant(int id,Participant participant) {
		// TODO Auto-generated method stub
		Sortie sortie= sortieService.findById(id);
		participant.setSortie(sortie);
		
	}
	

}
