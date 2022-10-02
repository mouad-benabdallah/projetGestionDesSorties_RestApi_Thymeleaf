package com.exo.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.exo.entities.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {
	public Page<Evaluation> findAllByOrderByNoteDesc(Pageable pageable);

}
