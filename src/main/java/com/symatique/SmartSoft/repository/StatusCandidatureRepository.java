package com.symatique.SmartSoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symatique.SmartSoft.models.StatusCandidature;


@Repository
public interface StatusCandidatureRepository extends JpaRepository<StatusCandidature, Long>  {

	Optional<StatusCandidature> findByLibelleAndSupressionAndIdNotAndIdEntreprise(String libelle,boolean supression ,  Long id,Long idEntreprise);

	Optional<StatusCandidature> findByLibelleAndSupressionAndIdEntreprise(String libelle,boolean supression, Long idEntreprise);

}
