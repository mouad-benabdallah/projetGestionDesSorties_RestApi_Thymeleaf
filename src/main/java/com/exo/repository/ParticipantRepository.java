package com.exo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exo.entities.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
	public List<Participant> findByNomAndPrenom(String nom,String prenom);
	public List<Participant> findByNomOrPrenom(String nom,String prenom);
	public Participant findByEmail(String email);

}
