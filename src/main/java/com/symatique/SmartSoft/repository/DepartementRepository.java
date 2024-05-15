package com.symatique.SmartSoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.symatique.SmartSoft.models.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long>{
	
	Optional<Departement> findByLibelleAndSupressionAndIdNotAndIdEntreprise(String libelle,boolean supression ,  Long id,Long idEntreprise);
	
	Optional<Departement> findByLibelleAndSupressionAndIdEntreprise(String libelle,boolean supression,Long idEntreprise);

}
