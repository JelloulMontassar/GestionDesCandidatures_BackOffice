package com.symatique.SmartSoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.symatique.SmartSoft.models.Domaine;


public interface DomaineRepository extends JpaRepository<Domaine, Long> {

	Optional<Domaine> findByLibelleAndSupressionAndIdNotAndEntrepriseId(String libelle,boolean supression , Long id,Long idEntreprise);

	Optional<Domaine> findByLibelleAndSupressionAndEntrepriseId(String libelle,boolean supression, Long idEntreprise);

}
