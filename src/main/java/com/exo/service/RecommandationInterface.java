package com.exo.service;



import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.exo.entities.Recommandation;

public interface RecommandationInterface {
	public Page<Recommandation> findall(Pageable pageable);
	public Recommandation addrecommandation(Recommandation recommandation);
	public void deletebyid(int id);
	public Optional<Recommandation> findById(int id);

}
