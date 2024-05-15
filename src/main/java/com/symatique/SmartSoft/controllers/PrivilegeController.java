package com.symatique.SmartSoft.controllers;

import java.util.ArrayList;
import java.util.List;

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

import com.symatique.SmartSoft.DTO.PrivilegeDTO;
import com.symatique.SmartSoft.models.Privilege;
import com.symatique.SmartSoft.services.PrivilegeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PrivilegeController {

	@Autowired
	private PrivilegeService privilegeService ;
	
	@Autowired
	private ModelMapper modelMapper ;
	
	@GetMapping("/allPrivilege")
	public ResponseEntity<List<PrivilegeDTO>> ListPrivilege() {
		List<Privilege> Privileges = privilegeService.getAllPrivileges();
		List<PrivilegeDTO> ListprivilegeDTO = new ArrayList<>();
		
		
	for (Privilege privilege : Privileges) {
		PrivilegeDTO privilegeDTO = modelMapper.map(privilege, PrivilegeDTO.class);
		ListprivilegeDTO.add(privilegeDTO);
	}
		
		return ResponseEntity.status(HttpStatus.OK).body(ListprivilegeDTO);
	}

	@GetMapping("/privilege/{idPrivilege}")
	public ResponseEntity<PrivilegeDTO> getPrivilege(@PathVariable("idPrivilege") Long id) {
		Privilege privilege = privilegeService.getPrivilege(id);
		PrivilegeDTO privilegeDTO = modelMapper.map(privilege, PrivilegeDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(privilegeDTO);
	}

	@PostMapping("/privilege")
	public ResponseEntity<Privilege> savePrivilege(@RequestBody Privilege privilege) {
		privilegeService.savePrivilege(privilege);
		return ResponseEntity.status(HttpStatus.CREATED).body(privilege);
	}

	@PutMapping("/privilege")
	public Object updatePrivilege(@RequestBody Privilege privilege) {
		privilege = privilegeService.updatePrivilege(privilege);
		return ResponseEntity.status(HttpStatus.CREATED).body(privilege);
	}

	@DeleteMapping("/privilege/{idPrivilege}")
	public Object deletePrivilege(@PathVariable("idPrivilege") Long id) {
		privilegeService.deletePrivilege(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	
	@GetMapping("/privilege/verifierLibelleId")
	public ResponseEntity<Boolean> checkLibelleExists(@RequestParam String libelle, @RequestParam Long id) {
		boolean exist = privilegeService.checkLibelleExists(libelle, id);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	
	@GetMapping("/privilege/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle) {
		boolean exist = privilegeService.checkLibelle(libelle);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	
	@PostMapping("/saveAllPrivilege")
	public ResponseEntity<List<Privilege>> saveAllPrivilege(
			@RequestBody List<Privilege> ListPrivilege) {
		privilegeService.saveAll(ListPrivilege);
		return ResponseEntity.status(HttpStatus.CREATED).body(ListPrivilege);
	}
	
	
	
	@GetMapping("/ListePrivilegeByLibelleIdEntreprise")
	public ResponseEntity<List<PrivilegeDTO>> searchByLibelleAndIdEntreprise(@RequestParam String libelle , @RequestParam Long idEntreprise) {
		List<Privilege> Privileges = privilegeService.searchByLibelleAndIdEntreprise(libelle,idEntreprise);
		List<PrivilegeDTO> ListprivilegeDTO = new ArrayList<>();
		
	for (Privilege privilege : Privileges) {
		PrivilegeDTO privilegeDTO = modelMapper.map(privilege, PrivilegeDTO.class);
		ListprivilegeDTO.add(privilegeDTO);
	}
		
		return ResponseEntity.status(HttpStatus.OK).body(ListprivilegeDTO);
	}
	
	@GetMapping("/ListePrivilegeByModuleIdEntreprise")
	public ResponseEntity<List<PrivilegeDTO>> searchByModuleAndIdEntreprise(@RequestParam String module , @RequestParam Long idEntreprise) {
		List<Privilege> Privileges = privilegeService.searchByModuleAndIdEntreprise(module,idEntreprise);
		List<PrivilegeDTO> ListprivilegeDTO = new ArrayList<>();
		
	for (Privilege privilege : Privileges) {
		PrivilegeDTO privilegeDTO = modelMapper.map(privilege, PrivilegeDTO.class);
		ListprivilegeDTO.add(privilegeDTO);
	}
		
		return ResponseEntity.status(HttpStatus.OK).body(ListprivilegeDTO);
	}
	

}


