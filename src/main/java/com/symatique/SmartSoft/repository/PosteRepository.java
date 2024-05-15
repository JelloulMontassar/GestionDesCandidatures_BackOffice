package com.symatique.SmartSoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.symatique.SmartSoft.models.Poste;

public interface PosteRepository extends JpaRepository<Poste, Long>{
		
	Optional<Poste> findByLibelleAndSupressionAndIdNotAndIdEntreprise(String libelle,boolean supression , Long id,Long idEntreprise);

	Optional<Poste> findByLibelleAndSupressionAndIdEntreprise(String libelle,boolean supression, Long idEntreprise);
	
	

}
