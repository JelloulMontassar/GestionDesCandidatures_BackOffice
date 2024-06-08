package com.symatique.SmartSoft.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.symatique.SmartSoft.DTO.CandidatDTO;
import org.modelmapper.ModelMapper;
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
	@Autowired
	private ModelMapper modelMapper ;
	@GetMapping("/allCandidat")
	public ResponseEntity<List<CandidatDTO>> ListCandidat() {
		List<Candidat> Candidats = CandidatService.getAllCandidats();
		List<CandidatDTO> CandidatDTOs = Candidats.stream().map(e -> modelMapper.map(e, CandidatDTO.class)).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(CandidatDTOs);
	}

	@GetMapping("/Candidat/{idCandidat}")
	public ResponseEntity<CandidatDTO> getCandidat(@PathVariable("idCandidat") Long id) {
		Candidat Candidat = CandidatService.getCandidatByUserID(id);
		CandidatDTO CandidatDTO = modelMapper.map(Candidat, CandidatDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(CandidatDTO);
	}

	@PostMapping("/Candidat")
	public ResponseEntity<Candidat> saveCandidat(@RequestBody Candidat Candidat) {
		CandidatService.saveCandidat(Candidat);
		return ResponseEntity.status(HttpStatus.CREATED).body(Candidat);
	}

	@PutMapping("/Candidat/{idCandidat}")
	public ResponseEntity<CandidatDTO> updateCandidat(@PathVariable Long idCandidat ,@RequestBody Candidat candidat) {
		Candidat candida = CandidatService.getCandidatByUserID(idCandidat);
		candida.setAdresse(candidat.getAdresse());
		candida.setNom(candidat.getNom());
		candida.setPrenom(candidat.getPrenom());
		candida.setDateNaissance(candidat.getDateNaissance());
		Candidat saved = CandidatService.saveCandidat(candida);
		CandidatDTO CandidatDTO = modelMapper.map(saved, CandidatDTO.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(CandidatDTO);
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
