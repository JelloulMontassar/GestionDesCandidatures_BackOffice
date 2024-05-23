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

import com.symatique.SmartSoft.models.Calendrier;
import com.symatique.SmartSoft.services.CalendrierService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CalendrierController {


	@Autowired
	private CalendrierService CalendrierService;
	
	@GetMapping("/allCalendrier")
	public ResponseEntity<List<Calendrier>> ListCalendrier(@RequestParam Long id) {
		List<Calendrier> Calendriers = CalendrierService.getAllCalendriers().stream().filter(e -> e.getId() == id).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(Calendriers);
	}

	@GetMapping("/Calendrier/{idCalendrier}")
	public ResponseEntity<Calendrier> getCalendrier(@PathVariable("idCalendrier") Long id) {
		Calendrier Calendrier = CalendrierService.getCalendrier(id);
		return ResponseEntity.status(HttpStatus.OK).body(Calendrier);
	}

	@PostMapping("/Calendrier")
	public ResponseEntity<Calendrier> saveCalendrier(@RequestBody Calendrier Calendrier) {
		CalendrierService.saveCalendrier(Calendrier);
		return ResponseEntity.status(HttpStatus.CREATED).body(Calendrier);
	}

	@PutMapping("/Calendrier")
	public Object updateCalendrier(@RequestBody Calendrier Calendrier) {
		Calendrier = CalendrierService.updateCalendrier(Calendrier);
		return ResponseEntity.status(HttpStatus.CREATED).body(Calendrier);
	}
	
	 @PutMapping("/Calendrier/{id}/suppression")
	    public ResponseEntity<Calendrier> updateSuppression(@PathVariable Long id) {
		 Calendrier Calendrier = CalendrierService.getCalendrier(id);

		 Calendrier.setSupression(true);

		 Calendrier updatedCalendrier = CalendrierService.saveCalendrier(Calendrier);
	        return ResponseEntity.ok(updatedCalendrier);
	    }

	@DeleteMapping("/Calendrier/{idCalendrier}")
	public Object deleteCalendrier(@PathVariable("idCalendrier") Long id) {
		CalendrierService.deleteCalendrier(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/Calendrier/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {
		boolean exist = CalendrierService.checkLibelle(libelle,idEntreprise);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

	
	
}
