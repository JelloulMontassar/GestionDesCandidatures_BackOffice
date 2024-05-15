package com.symatique.SmartSoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.symatique.SmartSoft.models.CategorieTypeUsage;

public interface CategorieTypeUsagerRepository extends JpaRepository<CategorieTypeUsage, Long> {

	Optional<CategorieTypeUsage> findByLibelleAndSupressionAndIdNotAndIdEntreprise(String libelle,boolean supression ,  Long id,Long idEntreprise);

	Optional<CategorieTypeUsage> findByLibelleAndSupressionAndIdEntreprise(String libelle,boolean supression, Long idEntreprise);

}
