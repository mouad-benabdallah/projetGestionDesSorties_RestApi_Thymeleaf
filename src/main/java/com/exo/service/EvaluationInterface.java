package com.exo.service;



import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.exo.entities.Evaluation;

public interface EvaluationInterface {
	public Page<Evaluation> findAll(Pageable pageable);
	public Evaluation addevaluation(Evaluation evaluation);
	public void deletebyid(int id);
	public Optional<Evaluation> findById(int id);
	public Page<Evaluation> findAllByOrderByNoteDesc(Pageable pageable);

}
