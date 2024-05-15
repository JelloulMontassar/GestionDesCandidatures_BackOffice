package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Profile;
import com.symatique.SmartSoft.repository.ProfileRepository;
import com.symatique.SmartSoft.services.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public Profile getProfile(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return profileRepository.findById(id).get();
	}

	@Override
	public List<Profile> getAllProfiles() {
		// TODO Auto-generated method stub
		
		 //return profileRepository.findAll();
		// return profileRepository.findAllByListPrivilegesIsNotNull();
		return profileRepository.findAll().stream().filter(profile -> profile.isSupression() == false).collect(Collectors.toList());		

	}

	@Override
	public Profile saveProfile(Profile profile) {
		// TODO Auto-generated method stub
		return profileRepository.save(profile);
	}

	@Override
	public Profile updateProfile( Profile profile) {
		
		// tempsReel.setId(id);
		return profileRepository.save(profile);
	}

	@Override
	public void deleteProfile(Long id) {
		// TODO Auto-generated method stub
		Profile profile = getProfile(id);
		profile.setSupression(true);
		profileRepository.save(profile);
	}
	
	public boolean checkLibelleExists(String libelle ,Long idEntreprise , Long id) {
	    // Recherche la puce avec le même numéro d'appel, en excluant celle avec l'id spécifié
	    Optional<Profile> existingProfile = profileRepository.findByLibelleAndSupressionAndIdNotAndIdEntreprise(libelle, false, id, idEntreprise);
	    // Si une puce est trouvée, cela signifie que le numéro d'appel existe déjà
	    return existingProfile.isPresent();
	  }
	
	
	public boolean checkLibelle(String libelle,Long idEntreprise) {

	    Optional<Profile> existingProfile = profileRepository.findByLibelleAndSupressionAndIdEntreprise(libelle, false, idEntreprise);


	    return existingProfile.isPresent();
	  }

	@Override
	public Profile getSuperProfile(String libelle, Long idEntreprise) {
		// TODO Auto-generated method stub
		return profileRepository.findByLibelleAndIdEntreprise(libelle, idEntreprise).get();
	}
	

}
