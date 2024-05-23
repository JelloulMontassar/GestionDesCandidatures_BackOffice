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

import com.symatique.SmartSoft.models.Evenement;
import com.symatique.SmartSoft.services.EvenementService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EvenementController {


	@Autowired
	private EvenementService EvenementService;
	
	@GetMapping("/allEvenement")
	public ResponseEntity<List<Evenement>> ListEvenement(@RequestParam Long id) {
		List<Evenement> Evenements = EvenementService.getAllEvenements().stream().filter(e -> e.getId() == id).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(Evenements);
	}

	@GetMapping("/Evenement/{idEvenement}")
	public ResponseEntity<Evenement> getEvenement(@PathVariable("idEvenement") Long id) {
		Evenement Evenement = EvenementService.getEvenement(id);
		return ResponseEntity.status(HttpStatus.OK).body(Evenement);
	}

	@PostMapping("/Evenement")
	public ResponseEntity<Evenement> saveEvenement(@RequestBody Evenement Evenement) {
		EvenementService.saveEvenement(Evenement);
		return ResponseEntity.status(HttpStatus.CREATED).body(Evenement);
	}

	@PutMapping("/Evenement")
	public Object updateEvenement(@RequestBody Evenement Evenement) {
		Evenement = EvenementService.updateEvenement(Evenement);
		return ResponseEntity.status(HttpStatus.CREATED).body(Evenement);
	}
	
	 @PutMapping("/Evenement/{id}/suppression")
	    public ResponseEntity<Evenement> updateSuppression(@PathVariable Long id) {
		 Evenement Evenement = EvenementService.getEvenement(id);

		 Evenement.setSupression(true);

		 Evenement updatedEvenement = EvenementService.saveEvenement(Evenement);
	        return ResponseEntity.ok(updatedEvenement);
	    }

	@DeleteMapping("/Evenement/{idEvenement}")
	public Object deleteEvenement(@PathVariable("idEvenement") Long id) {
		EvenementService.deleteEvenement(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/Evenement/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {
		boolean exist = EvenementService.checkLibelle(libelle,idEntreprise);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

	
	
}
