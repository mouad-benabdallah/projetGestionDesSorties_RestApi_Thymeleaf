package com.exo.service;



import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.exo.entities.Sortie;

public interface SortieInterface {
	public Page<Sortie> readall(Pageable Pageable);
	public Sortie addsortie(Sortie sortie);
	public void deletebyid(int id);
	public Sortie findById(int id);
	public Sortie findByTitre(String titre);
	public Sortie findByDestination(String destination);
	public List<Sortie> findByDepart(String depart);
	public List<Sortie> findByRetour(String retour);
	public Sortie findByAdmin(String responsable);
	public void addAdminToSortie(String nom,Sortie sortie);

}
