package com.symatique.SmartSoft.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

import com.symatique.SmartSoft.DTO.DomaineDTO;
import com.symatique.SmartSoft.models.Domaine;
import com.symatique.SmartSoft.services.DomaineService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DomaineController {

	@Autowired
	private DomaineService domaineService;
	
	@Autowired
	private ModelMapper modelMapper ;

	@GetMapping("/allDomaine")
	public ResponseEntity<List<DomaineDTO>> ListDomaine(@RequestParam Long id) {
		List<Domaine> domaines = domaineService.getAllDomaines().stream().filter(e -> e.getEntreprise().getId() == id && !e.isSupression()).collect(Collectors.toList());
		List<DomaineDTO> ListDomaineDTO = new ArrayList<>();

		for (Domaine domaine : domaines) {
				DomaineDTO domaineDTO = modelMapper.map(domaine, DomaineDTO.class);
				ListDomaineDTO.add(domaineDTO);
		}

		return ResponseEntity.status(HttpStatus.OK).body(ListDomaineDTO);
	}

	@GetMapping("/domaine/{idDomaine}")
	public ResponseEntity<DomaineDTO> getDomaine(@PathVariable("idDomaine") Long id) {
		Domaine domaine = domaineService.getDomaine(id);
		DomaineDTO domaineDTO = modelMapper.map(domaine, DomaineDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(domaineDTO);
	}

	@PostMapping("/domaine")
	public ResponseEntity<Domaine> saveDomaine(@RequestBody Domaine domaine) {
		domaineService.saveDomaine(domaine);
		return ResponseEntity.status(HttpStatus.CREATED).body(domaine);
	}

	@PutMapping("/domaine")
	public Object updateDomaine(@RequestBody Domaine domaine) {
		domaine = domaineService.updateDomaine(domaine);
		return ResponseEntity.status(HttpStatus.CREATED).body(domaine);
	}

	@DeleteMapping("/domaine/{idDomaine}")
	public Object deleteDomaine(@PathVariable("idDomaine") Long id) {
		domaineService.deleteDomaine(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@GetMapping("/domaine/verifierLibelleId")
	public ResponseEntity<Boolean> checkLibelleExists(@RequestParam String libelle, @RequestParam Long idEntreprise, @RequestParam Long id) {
		boolean exist = domaineService.checkLibelleExists(libelle,idEntreprise ,id);

		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

	@GetMapping("/domaine/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {

		boolean exist = domaineService.checkLibelle(libelle,idEntreprise);

		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

}
