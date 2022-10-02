package com.exo.calcule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.exo.entities.Evaluation;
import com.exo.entities.Participant;
import com.exo.entities.Sortie;
import com.exo.repository.EvaluationRepository;
import com.exo.repository.ParticipantRepository;
import com.exo.repository.SortieRepository;


public class Calcule {
	@Autowired
	SortieRepository sortieRepository;
	@Autowired
	ParticipantRepository participantRepository;
	@Autowired
	EvaluationRepository evaluationRepository;
	
	
	
	public double moyenneprix() {
		List<Sortie> sorties = sortieRepository.findAll();
		double somme=0;
		double moyenne = 0;
		for(Sortie s:sorties) {
			somme = somme+s.getPrix();
			
		}
		moyenne = somme/sorties.size();
		return moyenne;
	}
	
	
		public int nombredesparticipant() {
		List<Participant> participants = participantRepository.findAll();
		return participants.size();
	}
		
		public double moyenneevaluation() {
			List<Evaluation> evaluations = evaluationRepository.findAll();
			double somme=0;
			double moyenne = 0;
			for(Evaluation e:evaluations) {
				somme = somme+e.getNote();
				
			}
			moyenne = somme/evaluations.size();
			return moyenne;
		}
		
}
