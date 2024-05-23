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

import com.symatique.SmartSoft.models.Recrutement;
import com.symatique.SmartSoft.services.RecrutementService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RecrutementController {


	@Autowired
	private RecrutementService RecrutementService;
	
	@GetMapping("/allRecrutement")
	public ResponseEntity<List<Recrutement>> ListRecrutement(@RequestParam Long id) {
		List<Recrutement> Recrutements = RecrutementService.getAllRecrutements().stream().filter(e -> e.getId() == id).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(Recrutements);
	}

	@GetMapping("/Recrutement/{idRecrutement}")
	public ResponseEntity<Recrutement> getRecrutement(@PathVariable("idRecrutement") Long id) {
		Recrutement Recrutement = RecrutementService.getRecrutement(id);
		return ResponseEntity.status(HttpStatus.OK).body(Recrutement);
	}

	@PostMapping("/Recrutement")
	public ResponseEntity<Recrutement> saveRecrutement(@RequestBody Recrutement Recrutement) {
		RecrutementService.saveRecrutement(Recrutement);
		return ResponseEntity.status(HttpStatus.CREATED).body(Recrutement);
	}

	@PutMapping("/Recrutement")
	public Object updateRecrutement(@RequestBody Recrutement Recrutement) {
		Recrutement = RecrutementService.updateRecrutement(Recrutement);
		return ResponseEntity.status(HttpStatus.CREATED).body(Recrutement);
	}
	
	 @PutMapping("/Recrutement/{id}/suppression")
	    public ResponseEntity<Recrutement> updateSuppression(@PathVariable Long id) {
		 Recrutement Recrutement = RecrutementService.getRecrutement(id);

		 Recrutement.setSupression(true);

		 Recrutement updatedRecrutement = RecrutementService.saveRecrutement(Recrutement);
	        return ResponseEntity.ok(updatedRecrutement);
	    }

	@DeleteMapping("/Recrutement/{idRecrutement}")
	public Object deleteRecrutement(@PathVariable("idRecrutement") Long id) {
		RecrutementService.deleteRecrutement(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/Recrutement/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {
		boolean exist = RecrutementService.checkLibelle(libelle,idEntreprise);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

	
	
}
