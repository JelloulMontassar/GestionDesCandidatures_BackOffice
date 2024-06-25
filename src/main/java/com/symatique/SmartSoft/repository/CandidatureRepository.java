package com.symatique.SmartSoft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symatique.SmartSoft.models.Candidature;


@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Long>  {

	Optional<Candidature> findByLibelleAndSupressionAndIdNotAndIdEntreprise(String libelle,boolean supression ,  Long id,Long idEntreprise);

	Optional<Candidature> findByLibelleAndSupressionAndIdEntreprise(String libelle,boolean supression, Long idEntreprise);

    List<Candidature> findByCandidatId(Long id);
}
