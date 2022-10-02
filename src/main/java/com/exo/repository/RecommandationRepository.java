package com.exo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exo.entities.Recommandation;

public interface RecommandationRepository extends JpaRepository<Recommandation, Integer> {

}
