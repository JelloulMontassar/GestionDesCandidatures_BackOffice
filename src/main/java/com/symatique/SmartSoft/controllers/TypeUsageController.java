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

import com.symatique.SmartSoft.DTO.TypeUsagerDTO;
import com.symatique.SmartSoft.models.TypeUsager;
import com.symatique.SmartSoft.services.TypeUsagerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TypeUsageController {
	
	@Autowired
	private TypeUsagerService typeUsagerService;
	
	@Autowired
	private ModelMapper modelMapper ;
	
	@GetMapping("/allTypeUsager")
	public ResponseEntity<List<TypeUsagerDTO>> listTypeUsager(@RequestParam Long id) {
	    List<TypeUsager> typeUsagers = typeUsagerService.getAllTypeUsagers().stream()
	            .filter(e -> e.getIdEntreprise().equals(id) && !e.isSupression())
	            .collect(Collectors.toList());

	    List<TypeUsagerDTO> listTypeUsagerDTO = new ArrayList<>();
	    for (TypeUsager typeUsager : typeUsagers) {
	    	TypeUsagerDTO typeUsagerDTO = modelMapper.map(typeUsager, TypeUsagerDTO.class);
	        listTypeUsagerDTO.add(typeUsagerDTO);
	    }

	    return ResponseEntity.status(HttpStatus.OK).body(listTypeUsagerDTO);
	}

	@GetMapping("/TypeUsager/{idTypeUsager}")
	public ResponseEntity<TypeUsagerDTO> getTypeUsager(@PathVariable("idTypeUsager") Long id) {
		TypeUsager typeUsager = typeUsagerService. getTypeUsager(id);
		TypeUsagerDTO typeUsagerDTO = modelMapper.map(typeUsager, TypeUsagerDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(typeUsagerDTO);
	   
	}

	@PostMapping("/TypeUsager")
	public ResponseEntity<TypeUsager> saveTypeUsager(@RequestBody TypeUsager typeUsager) {
		typeUsagerService.saveTypeUsager(typeUsager);
		return ResponseEntity.status(HttpStatus.CREATED).body(typeUsager);
	}

	@PutMapping("/TypeUsager")
	public Object updateTypeUsager(@RequestBody TypeUsager typeUsager) {
		typeUsager = typeUsagerService.updateTypeUsager(typeUsager);
		return ResponseEntity.status(HttpStatus.CREATED).body(typeUsager);
	}

	@PutMapping("/TypeUsager/{id}/suppression")
    public ResponseEntity<TypeUsager> updateSuppression(@PathVariable Long id) {
		TypeUsager typeUsager = typeUsagerService.getTypeUsager(id);

		typeUsager.setSupression(true);

        TypeUsager updatedArticle = typeUsagerService.saveTypeUsager(typeUsager);
        return ResponseEntity.ok(updatedArticle);
    }
	
	@DeleteMapping("/TypeUsager/{idTypeUsager}")
	public Object deleteTypeUsager(@PathVariable("idTypeUsager") Long id) {
		typeUsagerService.deleteTypeUsager(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/typeusager/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {
		boolean exist = typeUsagerService.checkLibelle(libelle,idEntreprise);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	
	@GetMapping("/TypeUsager/verifierLibelleId")
	public ResponseEntity<Boolean> checkLibelleExists(@RequestParam String libelle, @RequestParam Long idEntreprise, @RequestParam Long id) {
		boolean exist = typeUsagerService.checkLibelleExists(libelle,idEntreprise, id);

		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	
}
