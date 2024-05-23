package com.symatique.SmartSoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symatique.SmartSoft.models.Calendrier;


@Repository
public interface CalendrierRepository extends JpaRepository<Calendrier, Long>  {

	Optional<Calendrier> findByLibelleAndSupressionAndIdNotAndIdEntreprise(String libelle,boolean supression ,  Long id,Long idEntreprise);

	Optional<Calendrier> findByLibelleAndSupressionAndIdEntreprise(String libelle,boolean supression, Long idEntreprise);

}
