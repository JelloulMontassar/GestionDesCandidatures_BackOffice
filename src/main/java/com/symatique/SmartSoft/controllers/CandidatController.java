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

import com.symatique.SmartSoft.models.Candidat;
import com.symatique.SmartSoft.services.CandidatService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CandidatController {


	@Autowired
	private CandidatService CandidatService;
	
	@GetMapping("/allCandidat")
	public ResponseEntity<List<Candidat>> ListCandidat(@RequestParam Long id) {
		List<Candidat> Candidats = CandidatService.getAllCandidats().stream().filter(e -> e.getId() == id).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(Candidats);
	}

	@GetMapping("/Candidat/{idCandidat}")
	public ResponseEntity<Candidat> getCandidat(@PathVariable("idCandidat") Long id) {
		Candidat Candidat = CandidatService.getCandidat(id);
		return ResponseEntity.status(HttpStatus.OK).body(Candidat);
	}

	@PostMapping("/Candidat")
	public ResponseEntity<Candidat> saveCandidat(@RequestBody Candidat Candidat) {
		CandidatService.saveCandidat(Candidat);
		return ResponseEntity.status(HttpStatus.CREATED).body(Candidat);
	}

	@PutMapping("/Candidat")
	public Object updateCandidat(@RequestBody Candidat Candidat) {
		Candidat = CandidatService.updateCandidat(Candidat);
		return ResponseEntity.status(HttpStatus.CREATED).body(Candidat);
	}
	
	 @PutMapping("/Candidat/{id}/suppression")
	    public ResponseEntity<Candidat> updateSuppression(@PathVariable Long id) {
		 Candidat Candidat = CandidatService.getCandidat(id);

		 Candidat.setSupression(true);

		 Candidat updatedCandidat = CandidatService.saveCandidat(Candidat);
	        return ResponseEntity.ok(updatedCandidat);
	    }

	@DeleteMapping("/Candidat/{idCandidat}")
	public Object deleteCandidat(@PathVariable("idCandidat") Long id) {
		CandidatService.deleteCandidat(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/Candidat/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {
		boolean exist = CandidatService.checkLibelle(libelle,idEntreprise);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

	
	
}
