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

import com.symatique.SmartSoft.DTO.PosteDTO;
import com.symatique.SmartSoft.models.Poste;
import com.symatique.SmartSoft.services.PosteService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PosteController {
	
	@Autowired
	private PosteService  posteService ;

	@Autowired
	private ModelMapper modelMapper ;
	
	
	@GetMapping("/allPoste")
	public ResponseEntity<List<PosteDTO>> ListPoste(@RequestParam Long id) {
		List<Poste> postes = posteService.getAllPostes().stream().filter(e -> e.getIdEntreprise() == id && !e.isSupression()).collect(Collectors.toList());
		
		List<PosteDTO> ListPosteDTO = new ArrayList<>();

		for (Poste poste : postes) {
				PosteDTO posteDTO = modelMapper.map(poste, PosteDTO.class);
				ListPosteDTO.add(posteDTO);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(ListPosteDTO);
	}

	@GetMapping("/poste/{idPoste}")
	public ResponseEntity<PosteDTO> getPoste(@PathVariable("idPoste") Long id) {
		Poste poste = posteService.getPoste(id);
		PosteDTO posteDTO = modelMapper.map(poste, PosteDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(posteDTO);
	}

	@PostMapping("/poste")
	public ResponseEntity<Poste> savePoste(@RequestBody Poste poste) {
		posteService.savePoste(poste);
		return ResponseEntity.status(HttpStatus.CREATED).body(poste);
	}

	@PutMapping("/poste")
	public Object updatePoste(@RequestBody Poste poste) {
		poste = posteService.updatePoste(poste);
		return ResponseEntity.status(HttpStatus.CREATED).body(poste);
	}

	@DeleteMapping("/poste/{idPoste}")
	public Object deletePoste(@PathVariable("idPoste") Long id) {
		posteService.deletePoste(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/poste/verifierLibelleId")
	public ResponseEntity<Boolean> checkLibelleExists(@RequestParam String libelle, @RequestParam Long idEntreprise, @RequestParam Long id) {
		boolean exist = posteService.checkLibelleExists(libelle,idEntreprise, id);

		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	
	@GetMapping("/poste/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {
		
		boolean exist = posteService.checkLibelle(libelle,idEntreprise);

		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	

}

