package com.symatique.SmartSoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symatique.SmartSoft.models.Recrutement;


@Repository
public interface RecrutementRepository extends JpaRepository<Recrutement, Long>  {

	Optional<Recrutement> findByLibelleAndSupressionAndIdNotAndIdEntreprise(String libelle,boolean supression ,  Long id,Long idEntreprise);

	Optional<Recrutement> findByLibelleAndSupressionAndIdEntreprise(String libelle,boolean supression, Long idEntreprise);

}
