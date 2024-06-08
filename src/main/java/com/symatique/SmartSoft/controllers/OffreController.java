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

import com.symatique.SmartSoft.models.Offre;
import com.symatique.SmartSoft.services.OffreService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class OffreController {


	@Autowired
	private OffreService OffreService;
	
	@GetMapping("/allOffre")
	public ResponseEntity<List<Offre>> ListOffre() {
		List<Offre> Offres = OffreService.getAllOffres();
		return ResponseEntity.status(HttpStatus.OK).body(Offres);
	}
	@GetMapping("/searchOffres")
	public List<Offre> searchOffres(
			@RequestParam(required = false) String libelle,
			@RequestParam(required = false) String localisation,
			@RequestParam(required = false) String description) {

		return OffreService.searchOffres(libelle, localisation, description);
	}

	@GetMapping("/Offre/{idOffre}")
	public ResponseEntity<Offre> getOffre(@PathVariable("idOffre") Long id) {
		Offre Offre = OffreService.getOffre(id);
		return ResponseEntity.status(HttpStatus.OK).body(Offre);
	}

	@PostMapping("/Offre")
	public ResponseEntity<Offre> saveOffre(@RequestBody Offre Offre) {
		OffreService.saveOffre(Offre);
		return ResponseEntity.status(HttpStatus.CREATED).body(Offre);
	}

	@PutMapping("/Offre")
	public Object updateOffre(@RequestBody Offre Offre) {
		Offre = OffreService.updateOffre(Offre);
		return ResponseEntity.status(HttpStatus.CREATED).body(Offre);
	}
	
	 @PutMapping("/Offre/{id}/suppression")
	    public ResponseEntity<Offre> updateSuppression(@PathVariable Long id) {
		 Offre Offre = OffreService.getOffre(id);

		 Offre.setSupression(true);

		 Offre updatedOffre = OffreService.saveOffre(Offre);
	        return ResponseEntity.ok(updatedOffre);
	    }

	@DeleteMapping("/Offre/{idOffre}")
	public Object deleteOffre(@PathVariable("idOffre") Long id) {
		OffreService.deleteOffre(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/Offre/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {
		System.out.println("libelle : "+libelle);
		boolean exist = OffreService.checkLibelle(libelle,idEntreprise);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

	
	
}
