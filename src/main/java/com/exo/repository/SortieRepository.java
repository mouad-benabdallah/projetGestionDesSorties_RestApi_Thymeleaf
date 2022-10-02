package com.exo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exo.entities.Sortie;

public interface SortieRepository extends JpaRepository<Sortie, Integer> {
	public Sortie findByTitre(String titre);
	public Sortie findByDestination(String destination);
	public List<Sortie> findByDepart(String depart);
	public List<Sortie> findByRetour(String retour);
	public Sortie findByAdmin(String responsable);
	public Sortie findById(int id);

}
