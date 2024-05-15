package com.symatique.SmartSoft.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.symatique.SmartSoft.models.Profile;
import com.symatique.SmartSoft.services.ProfileService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProfileController {
	
	@Autowired
	private ProfileService  profileService ;

	@GetMapping("/allProfile")
	public ResponseEntity<List<Profile>> ListProfile(@RequestParam Long id) {
		List<Profile> profiles = profileService.getAllProfiles().stream().filter(e -> e.getIdEntreprise() == id).collect(Collectors.toList());
		
	
		return ResponseEntity.status(HttpStatus.OK).body(profiles);
	}

	@GetMapping("/profile/{idProfile}")
	public ResponseEntity<Profile> getProfile(@PathVariable("idProfile") Long id) {
		Profile Profile = profileService.getProfile(id);
		return ResponseEntity.status(HttpStatus.OK).body(Profile);
	}

	@PostMapping("/profile")
	public ResponseEntity<Profile> saveProfile(@RequestBody Profile profile) {
		profileService.saveProfile(profile);
		return ResponseEntity.status(HttpStatus.CREATED).body(profile);
	}

	@PutMapping("/profile")
	public Object updateProfile(@RequestBody Profile profile) {
		profile = profileService.updateProfile( profile);
		return ResponseEntity.status(HttpStatus.CREATED).body(profile);
	}

	@DeleteMapping("/profile/{idProfile}")
	public Object deleteProfile(@PathVariable("idProfile") Long id) {
		profileService.deleteProfile(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/profile/verifierLibelleId")
	public ResponseEntity<Boolean> checkLibelleExists(@RequestParam String libelle, @RequestParam Long idEntreprise, @RequestParam Long id) {
		boolean exist = profileService.checkLibelleExists(libelle,idEntreprise ,id);

		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	
	@GetMapping("/profile/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {
		
		boolean exist = profileService.checkLibelle(libelle,idEntreprise);

		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	
	
	@GetMapping("/SuperProfile")
	public ResponseEntity<Profile> getSuperProfile(@RequestParam Long idEntreprise) {
		Profile Profile = profileService.getSuperProfile("Super Admin", idEntreprise);
		return ResponseEntity.status(HttpStatus.OK).body(Profile);
	}

}