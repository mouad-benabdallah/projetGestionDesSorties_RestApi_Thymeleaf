package com.exo.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exo.entities.Admin;
import com.exo.entities.Sortie;
import com.exo.repository.AdminRepository;
import com.exo.repository.SortieRepository;

@Service
public class SortieService implements SortieInterface {
	@Autowired
	SortieRepository sortieRepository;
	@Autowired
	AdminRepository adminRepository;

	@Override
	public Page<Sortie> readall(Pageable pageable) {
		// TODO Auto-generated method stub
		return sortieRepository.findAll(pageable);
	}

	@Override
	public Sortie addsortie(Sortie sortie) {
		// TODO Auto-generated method stub
		return sortieRepository.save(sortie);
	}

	@Override
	public void deletebyid(int id) {
		// TODO Auto-generated method stub
		sortieRepository.deleteById(id);
	}

	@Override
	public Sortie findById(int id) {
		// TODO Auto-generated method stub
		return sortieRepository.findById(id);
	}

	@Override
	public Sortie findByTitre(String titre) {
		// TODO Auto-generated method stub
		return sortieRepository.findByTitre(titre);
	}

	@Override
	public Sortie findByDestination(String destination) {
		// TODO Auto-generated method stub
		return sortieRepository.findByDestination(destination);
	}

	@Override
	public List<Sortie> findByDepart(String depart) {
		// TODO Auto-generated method stub
		return sortieRepository.findByDepart(depart);
	}

	@Override
	public List<Sortie> findByRetour(String retour) {
		// TODO Auto-generated method stub
		return sortieRepository.findByRetour(retour);
	}

	@Override
	public Sortie findByAdmin(String responsable) {
		// TODO Auto-generated method stub
		return sortieRepository.findByAdmin(responsable);
	}

	@Override
	public void addAdminToSortie(String nom, Sortie sortie) {
		// TODO Auto-generated method stub
		Admin ad = adminRepository.findByNomComplet(nom);
		sortie.setAdmin(ad);
		sortieRepository.save(sortie);
	}

	
	

}
