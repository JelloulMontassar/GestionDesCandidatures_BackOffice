package com.symatique.SmartSoft.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.symatique.SmartSoft.DTO.CandidatDTO;
import com.symatique.SmartSoft.DTO.CandidatureDTO;
import com.symatique.SmartSoft.models.Candidat;
import com.symatique.SmartSoft.services.CandidatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.symatique.SmartSoft.models.Candidature;
import com.symatique.SmartSoft.services.CandidatureService;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CandidatureController {


	@Autowired
	private CandidatureService CandidatureService;
	@Autowired
	private CandidatService candidatService;
	@Autowired
	private ModelMapper modelMapper ;
	@GetMapping("/allCandidature")
	public ResponseEntity<List<CandidatureDTO>> ListCandidature() {
		List<Candidature> Candidatures = CandidatureService.getAllCandidatures();
		List<CandidatureDTO> CandidatureDTOs = Candidatures.stream().map(e -> modelMapper.map(e, CandidatureDTO.class)).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(CandidatureDTOs);
	}

	@GetMapping("/Candidature/{idCandidature}")
	public ResponseEntity<Candidature> getCandidature(@PathVariable("idCandidature") Long id) {
		Candidature Candidature = CandidatureService.getCandidature(id);
		return ResponseEntity.status(HttpStatus.OK).body(Candidature);
	}

	@PostMapping("/Candidature")
	public ResponseEntity<Candidature> saveCandidature(@RequestBody Candidature candidature) {
		candidature.setEtat(0);
		CandidatureService.saveCandidature(candidature);
		return ResponseEntity.status(HttpStatus.CREATED).body(candidature);
	}

	@PutMapping("/Candidature")
	public Object updateCandidature(@RequestBody Candidature Candidature) {
		Candidature = CandidatureService.updateCandidature(Candidature);
		return ResponseEntity.status(HttpStatus.CREATED).body(Candidature);
	}
	@PutMapping("/Candidature/{id}/{etat}")
	public ResponseEntity<CandidatureDTO> updateEtatCandidature(@PathVariable Long id, @PathVariable int etat) {
		Candidature candidature = CandidatureService.getCandidature(id);
		candidature.setEtat(etat);
		Candidature candidature1 = CandidatureService.saveCandidature(candidature);
		CandidatureDTO CandidatureDTO = modelMapper.map(candidature1, CandidatureDTO.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(CandidatureDTO);
	}
	
	 @PutMapping("/Candidature/{id}/suppression")
	    public ResponseEntity<Candidature> updateSuppression(@PathVariable Long id) {
		 Candidature Candidature = CandidatureService.getCandidature(id);

		 Candidature.setSupression(true);

		 Candidature updatedCandidature = CandidatureService.saveCandidature(Candidature);
	        return ResponseEntity.ok(updatedCandidature);
	    }

	@DeleteMapping("/Candidature/{idCandidature}")
	public Object deleteCandidature(@PathVariable("idCandidature") Long id) {
		CandidatureService.deleteCandidature(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/Candidature/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {
		boolean exist = CandidatureService.checkLibelle(libelle,idEntreprise);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	@Value("${file.upload-dir}")
	private String uploadDir;
	@PostMapping("/Candidature/uploadCv")
	public ResponseEntity<CandidatDTO> uploadCv(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
		try {
			String fileName = file.getOriginalFilename();

			Path path = Paths.get(uploadDir + fileName);

			Files.write(path, file.getBytes());

			Candidat candidat = candidatService.getCandidatByUserID(id);

			candidat.setCvPath(path.toString());

			candidatService.saveCandidat(candidat);
			CandidatDTO CandidatDTO = modelMapper.map(candidat, CandidatDTO.class);
			return ResponseEntity.status(HttpStatus.CREATED).body(CandidatDTO);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	
}
