package com.exo.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exo.entities.Recommandation;
import com.exo.repository.RecommandationRepository;

@Service
public class RecommandationService implements RecommandationInterface {
	@Autowired
	RecommandationRepository recommandationRepository;

	@Override
	public Page<Recommandation> findall(Pageable pageable) {
		// TODO Auto-generated method stub
		return recommandationRepository.findAll(pageable);
	}

	@Override
	public Recommandation addrecommandation(Recommandation recommandation) {
		// TODO Auto-generated method stub
		return recommandationRepository.save(recommandation);
	}

	@Override
	public void deletebyid(int id) {
		// TODO Auto-generated method stub
		recommandationRepository.deleteById(id);
	}

	@Override
	public  Optional<Recommandation> findById(int id) {
		// TODO Auto-generated method stub
		return recommandationRepository.findById(id);
	}

}
