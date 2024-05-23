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

import com.symatique.SmartSoft.models.Candidature;
import com.symatique.SmartSoft.services.CandidatureService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CandidatureController {


	@Autowired
	private CandidatureService CandidatureService;
	
	@GetMapping("/allCandidature")
	public ResponseEntity<List<Candidature>> ListCandidature(@RequestParam Long id) {
		List<Candidature> Candidatures = CandidatureService.getAllCandidatures().stream().filter(e -> e.getId() == id).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(Candidatures);
	}

	@GetMapping("/Candidature/{idCandidature}")
	public ResponseEntity<Candidature> getCandidature(@PathVariable("idCandidature") Long id) {
		Candidature Candidature = CandidatureService.getCandidature(id);
		return ResponseEntity.status(HttpStatus.OK).body(Candidature);
	}

	@PostMapping("/Candidature")
	public ResponseEntity<Candidature> saveCandidature(@RequestBody Candidature Candidature) {
		CandidatureService.saveCandidature(Candidature);
		return ResponseEntity.status(HttpStatus.CREATED).body(Candidature);
	}

	@PutMapping("/Candidature")
	public Object updateCandidature(@RequestBody Candidature Candidature) {
		Candidature = CandidatureService.updateCandidature(Candidature);
		return ResponseEntity.status(HttpStatus.CREATED).body(Candidature);
	}
	
	 @PutMapping("/Candidature/{id}/suppression")
	    public ResponseEntity<Candidature> updateSuppression(@PathVariable Long id) {
		 Candidature Candidature = CandidatureService.getCandidature(id);

		 Candidature.setSupression(true);

		 Candidature updatedCandidature = CandidatureService.saveCandidature(Candidature);
	        return ResponseEntity.ok(updatedCandidature);
	    }

	@DeleteMapping("/Candidature/{idCandidature}")
	public Object deleteCandidature(@PathVariable("idCandidature") Long id) {
		CandidatureService.deleteCandidature(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/Candidature/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {
		boolean exist = CandidatureService.checkLibelle(libelle,idEntreprise);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

	
	
}
