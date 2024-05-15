package com.symatique.SmartSoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.symatique.SmartSoft.models.Emplacement;

public interface EmplacementRepository extends JpaRepository<Emplacement, Long>{
	
	Optional<Emplacement> findByLibelleAndSupressionAndIdNotAndIdEntreprise(String libelle,boolean supression , Long id,Long idEntreprise);

	Optional<Emplacement> findByLibelleAndSupressionAndIdEntreprise(String libelle,boolean supression, Long idEntreprise);
	
	
}
