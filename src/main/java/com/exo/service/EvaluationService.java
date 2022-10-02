package com.exo.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exo.entities.Evaluation;
import com.exo.repository.EvaluationRepository;

@Service
public class EvaluationService implements EvaluationInterface{
	@Autowired
	EvaluationRepository evaluationRepository;

	@Override
	public Page<Evaluation> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return evaluationRepository.findAll(pageable);
	}

	@Override
	public Evaluation addevaluation(Evaluation evaluation) {
		// TODO Auto-generated method stub
		return evaluationRepository.save(evaluation);
	}

	@Override
	public void deletebyid(int id) {
		// TODO Auto-generated method stub
		evaluationRepository.deleteById(id);
	}

	@Override
	public Optional<Evaluation> findById(int id) {
		// TODO Auto-generated method stub
		return evaluationRepository.findById(id);
	}

	@Override
	public Page<Evaluation> findAllByOrderByNoteDesc(Pageable pageable) {
		// TODO Auto-generated method stub
		return evaluationRepository.findAllByOrderByNoteDesc(pageable);
	}

}
