package com.symatique.SmartSoft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symatique.SmartSoft.models.Candidat;


@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long>  {

	Optional<Candidat> findByLibelleAndSupressionAndIdNotAndIdEntreprise(String libelle,boolean supression ,  Long id,Long idEntreprise);

	Optional<Candidat> findByLibelleAndSupressionAndIdEntreprise(String libelle,boolean supression, Long idEntreprise);

    Candidat findByUtilisateurId(Long id);
}
