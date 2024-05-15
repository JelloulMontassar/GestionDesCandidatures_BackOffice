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

import com.symatique.SmartSoft.models.Entreprise;
import com.symatique.SmartSoft.services.EntrepriseService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EntrepriseController {

	@Autowired
	private EntrepriseService  entrepriseService ;
	
	
	@GetMapping("/allEntreprise")
	public ResponseEntity<List<Entreprise>> ListEntreprise(@RequestParam Long id) {
		List<Entreprise> entreprises = entrepriseService.getAllEntreprises().stream().filter(e -> e.getId() == id).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(entreprises);
	}

	@GetMapping("/entreprise/{idEntreprise}")
	public ResponseEntity<Entreprise> getEntreprise(@PathVariable("idEntreprise") Long id) {
		Entreprise entreprise = entrepriseService.getEntreprise(id);
		return ResponseEntity.status(HttpStatus.OK).body(entreprise);
	}

	@PostMapping("/entreprise")
	public ResponseEntity<Entreprise> saveEntreprise(@RequestBody Entreprise entreprise) {
		entrepriseService.saveEntreprise(entreprise);
		return ResponseEntity.status(HttpStatus.CREATED).body(entreprise);
	}

	@PutMapping("/entreprise")
	public Object updateEntreprise(@RequestBody Entreprise entreprise) {
		entreprise = entrepriseService.updateEntreprise( entreprise);
		return ResponseEntity.status(HttpStatus.CREATED).body(entreprise);
	}

	@DeleteMapping("/entreprise/{idEntreprise}")
	public Object deleteEntreprise(@PathVariable("idEntreprise") Long id) {
		entrepriseService.deleteEntreprise(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	
	
	@GetMapping("/entreprise/verifierLibelleId")
	public ResponseEntity<Boolean> checkLibelleExists(@RequestParam String libelle, @RequestParam Long id) {
		boolean exist = entrepriseService.checkLibelleExists(libelle, id);

		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	
	@GetMapping("/entreprise/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle) {
		
		boolean exist = entrepriseService.checkLibelle(libelle);

		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	
	@GetMapping("/entreprise/all")
	public ResponseEntity<List<Entreprise>> ListDataEntreprise() {
		List<Entreprise> entreprises = entrepriseService.getAllEntreprises();
		return ResponseEntity.status(HttpStatus.OK).body(entreprises);
	}

}


