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

import com.symatique.SmartSoft.models.Emplacement;
import com.symatique.SmartSoft.services.EmplacementService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EmplacementController {

	@Autowired
	private EmplacementService emplacementService;

	@GetMapping("/allEmplacement")
	public ResponseEntity<List<Emplacement>> ListEmplacement(@RequestParam Long id) {
		List<Emplacement> emplacements = emplacementService.getAllEmplacements().stream().filter(e -> e.getIdEntreprise() == id).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(emplacements);

	}

	@GetMapping("/emplacement/{idEmplacement}")
	public ResponseEntity<Emplacement> getemplacement(@PathVariable("idEmplacement") Long id) {
		Emplacement emplacement = emplacementService.getEmplacement(id);

		return ResponseEntity.status(HttpStatus.OK).body(emplacement);
	}

	@PostMapping("/emplacement")
	public ResponseEntity<Emplacement> saveemplacement(@RequestBody Emplacement emplacement) {
		emplacementService.saveEmplacement(emplacement);
		return ResponseEntity.status(HttpStatus.CREATED).body(emplacement);
	}

	@PutMapping("/emplacement")
	public Object updateemplacement(@RequestBody Emplacement emplacement) {
		emplacement = emplacementService.updateEmplacement(emplacement);
		return ResponseEntity.status(HttpStatus.CREATED).body(emplacement);
	}

	@DeleteMapping("/emplacement/{idemplacement}")
	public Object deleteemplacement(@PathVariable("idemplacement") Long id) {
		emplacementService.deleteEmplacement(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@GetMapping("/emplacement/verifierLibelleId")
	public ResponseEntity<Boolean> checkLibelleExists(@RequestParam String libelle, @RequestParam Long idEntreprise, @RequestParam Long id) {
		boolean exist = emplacementService.checkLibelleExists(libelle,idEntreprise, id);

		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

	@GetMapping("/emplacement/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {

		boolean exist = emplacementService.checkLibelle(libelle,idEntreprise);

		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	
	
	@GetMapping("/emplacement/modifierLibelleEmplacement")
	public ResponseEntity<Boolean> modifierAffectationBatiment(@RequestParam String oldLibelle, @RequestParam String newLibelle) {
		boolean modifier = emplacementService.modifierLibelleEmplacement(oldLibelle ,newLibelle );
		return ResponseEntity.status(HttpStatus.OK).body(modifier);
	}
	
	
	@GetMapping("/emplacement/verifierDetail/{libelleEmplacement}")
	public ResponseEntity<Boolean> verifierAffectation(@PathVariable("libelleEmplacement") String libelleEmplacement) {
		boolean exist = !emplacementService.verifierExistsDetails(libelleEmplacement);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

}
