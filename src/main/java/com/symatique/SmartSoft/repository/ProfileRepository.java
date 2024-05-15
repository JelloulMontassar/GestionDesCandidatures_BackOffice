package com.symatique.SmartSoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.symatique.SmartSoft.models.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

	Optional<Profile> findByLibelleAndSupressionAndIdNotAndIdEntreprise(String libelle,boolean supression , Long id,Long idEntreprise);

	Optional<Profile> findByLibelleAndSupressionAndIdEntreprise(String libelle,boolean supression, Long idEntreprise);
	
	Optional<Profile> findByLibelleAndIdEntreprise(String libelle,Long id);

}
