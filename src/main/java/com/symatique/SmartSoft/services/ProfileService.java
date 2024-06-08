package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Profile;

@Service
public interface ProfileService {

	Profile getProfile(Long id);

	List<Profile> getAllProfiles();

	Profile saveProfile(Profile profile);

	Profile updateProfile( Profile profile);

	void deleteProfile(Long id);
	
	boolean checkLibelleExists(String libelle, Long idEntreprise, Long id);
	
	boolean checkLibelle(String libelle,Long idEntreprise);
	
	Profile getSuperProfile(String libelle ,Long idEntreprise);

	Profile getCandidatProfile(String candidat);
}
