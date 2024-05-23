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

import com.symatique.SmartSoft.models.StatusCandidature;
import com.symatique.SmartSoft.services.StatusCandidatureService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class StatusCandidatureController {


	@Autowired
	private StatusCandidatureService StatusCandidatureService;
	
	@GetMapping("/allStatusCandidature")
	public ResponseEntity<List<StatusCandidature>> ListStatusCandidature(@RequestParam Long id) {
		List<StatusCandidature> StatusCandidatures = StatusCandidatureService.getAllStatusCandidatures().stream().filter(e -> e.getId() == id).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(StatusCandidatures);
	}

	@GetMapping("/StatusCandidature/{idStatusCandidature}")
	public ResponseEntity<StatusCandidature> getStatusCandidature(@PathVariable("idStatusCandidature") Long id) {
		StatusCandidature StatusCandidature = StatusCandidatureService.getStatusCandidature(id);
		return ResponseEntity.status(HttpStatus.OK).body(StatusCandidature);
	}

	@PostMapping("/StatusCandidature")
	public ResponseEntity<StatusCandidature> saveStatusCandidature(@RequestBody StatusCandidature StatusCandidature) {
		StatusCandidatureService.saveStatusCandidature(StatusCandidature);
		return ResponseEntity.status(HttpStatus.CREATED).body(StatusCandidature);
	}

	@PutMapping("/StatusCandidature")
	public Object updateStatusCandidature(@RequestBody StatusCandidature StatusCandidature) {
		StatusCandidature = StatusCandidatureService.updateStatusCandidature(StatusCandidature);
		return ResponseEntity.status(HttpStatus.CREATED).body(StatusCandidature);
	}
	
	 @PutMapping("/StatusCandidature/{id}/suppression")
	    public ResponseEntity<StatusCandidature> updateSuppression(@PathVariable Long id) {
		 StatusCandidature StatusCandidature = StatusCandidatureService.getStatusCandidature(id);

		 StatusCandidature.setSupression(true);

		 StatusCandidature updatedStatusCandidature = StatusCandidatureService.saveStatusCandidature(StatusCandidature);
	        return ResponseEntity.ok(updatedStatusCandidature);
	    }

	@DeleteMapping("/StatusCandidature/{idStatusCandidature}")
	public Object deleteStatusCandidature(@PathVariable("idStatusCandidature") Long id) {
		StatusCandidatureService.deleteStatusCandidature(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/StatusCandidature/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {
		boolean exist = StatusCandidatureService.checkLibelle(libelle,idEntreprise);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

	
	
}
