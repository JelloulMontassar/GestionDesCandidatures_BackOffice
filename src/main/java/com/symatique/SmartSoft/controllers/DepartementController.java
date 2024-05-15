package com.symatique.SmartSoft.controllers;

import java.util.List;

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

import com.symatique.SmartSoft.models.Departement;
import com.symatique.SmartSoft.services.DepartementService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DepartementController {

	@Autowired
	private DepartementService departementService;

	@GetMapping("/allDepartement")
	public ResponseEntity<List<Departement>> ListCentre(@RequestParam Long id) {
		List<Departement> centres = departementService.getAllDepartements(id);
		return ResponseEntity.status(HttpStatus.OK).body(centres);
	}

	@GetMapping("/departement/{idDepartement}")
	public ResponseEntity<Departement> getCentre(@PathVariable("idDepartement") Long id) {
		Departement departement = departementService.getDepartement(id);
		return ResponseEntity.status(HttpStatus.OK).body(departement);
	}

	@PostMapping("/departement")
	public ResponseEntity<Departement> saveCentre(@RequestBody Departement departement) {
		departementService.saveDepartement(departement);
		return ResponseEntity.status(HttpStatus.CREATED).body(departement);
	}

	@PutMapping("/departement")
	public Object updateCentre(@RequestBody Departement departement) {
		departement = departementService.updateDepartement(departement);
		return ResponseEntity.status(HttpStatus.CREATED).body(departement);
	}

	@DeleteMapping("/departement/{idDepartement}")
	public Object deleteCentre(@PathVariable("idDepartement") Long id) {
		departementService.deleteDepartement(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@GetMapping("/departement/verifierLibelleId")
	public ResponseEntity<Boolean> checkLibelleExists(@RequestParam String libelle, @RequestParam Long idEntreprise, @RequestParam Long id) {
		boolean exist = departementService.checkLibelleExists(libelle,idEntreprise ,id);

		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	
	@GetMapping("/departement/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {
		
		boolean exist = departementService.checkLibelle(libelle,idEntreprise);

		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	
}
