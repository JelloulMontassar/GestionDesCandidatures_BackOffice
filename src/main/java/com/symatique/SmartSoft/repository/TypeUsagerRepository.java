package com.symatique.SmartSoft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.symatique.SmartSoft.models.CategorieTypeUsage;
import com.symatique.SmartSoft.models.TypeUsager;

public interface TypeUsagerRepository extends JpaRepository<TypeUsager, Long> {

	Optional<TypeUsager> findByLibelleAndSupressionAndIdEntreprise(String libelle,boolean supression, Long idEntreprise);

	Optional<TypeUsager> findByLibelleAndSupressionAndIdNotAndIdEntreprise(String libelle,boolean supression ,  Long id,Long idEntreprise);

    List<TypeUsager> findByIdEntrepriseAndCategorieTypeUsageIdAndSupressionFalse(Long idEntreprise, Long categorieTypeUsageId);
	
	//TypeUsager findByCycleParam(CycleParam cycleParam);
}
