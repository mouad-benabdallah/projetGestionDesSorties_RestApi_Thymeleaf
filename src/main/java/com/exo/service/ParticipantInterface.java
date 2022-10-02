package com.exo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.exo.entities.Participant;

public interface ParticipantInterface {
	public Page<Participant> findall(Pageable pageable);
	public Participant addparticipent(Participant participant);
	public void deletebyid(int id);
	public Optional<Participant> findById(int id);
	public List<Participant> findByNomAndPrenom(String nom,String prenom);
	public List<Participant> findByNomOrPrenom(String nom,String prenom);
	public Participant findByEmail(String email);
	public void addSortieToParticipant(int id,Participant participant);

}
