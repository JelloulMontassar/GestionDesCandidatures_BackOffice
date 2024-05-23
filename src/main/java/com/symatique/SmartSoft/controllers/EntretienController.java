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

import com.symatique.SmartSoft.models.Entretien;
import com.symatique.SmartSoft.services.EntretienService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EntretienController {


	@Autowired
	private EntretienService EntretienService;
	
	@GetMapping("/allEntretien")
	public ResponseEntity<List<Entretien>> ListEntretien(@RequestParam Long id) {
		List<Entretien> Entretiens = EntretienService.getAllEntretiens().stream().filter(e -> e.getId() == id).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(Entretiens);
	}

	@GetMapping("/Entretien/{idEntretien}")
	public ResponseEntity<Entretien> getEntretien(@PathVariable("idEntretien") Long id) {
		Entretien Entretien = EntretienService.getEntretien(id);
		return ResponseEntity.status(HttpStatus.OK).body(Entretien);
	}

	@PostMapping("/Entretien")
	public ResponseEntity<Entretien> saveEntretien(@RequestBody Entretien Entretien) {
		EntretienService.saveEntretien(Entretien);
		return ResponseEntity.status(HttpStatus.CREATED).body(Entretien);
	}

	@PutMapping("/Entretien")
	public Object updateEntretien(@RequestBody Entretien Entretien) {
		Entretien = EntretienService.updateEntretien(Entretien);
		return ResponseEntity.status(HttpStatus.CREATED).body(Entretien);
	}
	
	 @PutMapping("/Entretien/{id}/suppression")
	    public ResponseEntity<Entretien> updateSuppression(@PathVariable Long id) {
		 Entretien Entretien = EntretienService.getEntretien(id);

		 Entretien.setSupression(true);

		 Entretien updatedEntretien = EntretienService.saveEntretien(Entretien);
	        return ResponseEntity.ok(updatedEntretien);
	    }

	@DeleteMapping("/Entretien/{idEntretien}")
	public Object deleteEntretien(@PathVariable("idEntretien") Long id) {
		EntretienService.deleteEntretien(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/Entretien/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {
		boolean exist = EntretienService.checkLibelle(libelle,idEntreprise);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

	
	
}
