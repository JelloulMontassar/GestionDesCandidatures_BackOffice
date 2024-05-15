package com.symatique.SmartSoft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.symatique.SmartSoft.models.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

	Optional<Privilege> findByLibelleAndSupressionAndIdNot(String libelle, boolean supression, Long id);

	Optional<Privilege> findByLibelleAndSupression(String libelle, boolean supression);

	List<Privilege> findByLibelleAndIdEntreprise(String libelle, Long entrepriseId);
	
	List<Privilege> findByModuleAndIdEntreprise(String libelle, Long entrepriseId);

}
