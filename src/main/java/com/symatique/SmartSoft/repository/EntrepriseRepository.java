package com.symatique.SmartSoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.symatique.SmartSoft.models.Entreprise;



public interface EntrepriseRepository extends JpaRepository<Entreprise, Long>{
	
	Optional<Entreprise> findByLibelleAndSupressionAndIdNot(String libelle, boolean supression, Long id);
	
	Optional<Entreprise> findByLibelleAndSupression(String libelle,boolean supression);
	

}
