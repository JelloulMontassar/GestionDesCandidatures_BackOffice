package com.symatique.SmartSoft.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.symatique.SmartSoft.models.DetailModuleInstalleParEntreprise;
import com.symatique.SmartSoft.models.ModuleInstalleParEntreprise;
import com.symatique.SmartSoft.services.DetailModuleInstalleParEntrepriseService;
import com.symatique.SmartSoft.services.ModuleInstalleParEntrepriseService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ModuleInstalleParEntrepriseController {
	
	@Autowired
	private ModuleInstalleParEntrepriseService moduleInstalleParEntrepriseService ;
	
	@Autowired
	private DetailModuleInstalleParEntrepriseService detailModuleInstalleParEntrepriseService ;

	
	
	@GetMapping("/allModule")
	public ResponseEntity<List<ModuleInstalleParEntreprise>> ListModule() {
		List<ModuleInstalleParEntreprise> Modules = moduleInstalleParEntrepriseService.getAllModuleInstalleParEntreprises();
		return ResponseEntity.status(HttpStatus.OK).body(Modules);
	}

	@GetMapping("/module/{idModule}")
	public ResponseEntity<ModuleInstalleParEntreprise> getModule(@PathVariable("idModule") Long id) {
		ModuleInstalleParEntreprise Module = moduleInstalleParEntrepriseService.getModuleInstalleParEntreprise(id);
		return ResponseEntity.status(HttpStatus.OK).body(Module);
	}

	@PostMapping("/module")
	public ResponseEntity<ModuleInstalleParEntreprise> saveModule(@RequestBody ModuleInstalleParEntreprise Module) {
		moduleInstalleParEntrepriseService.saveModele(Module);
		return ResponseEntity.status(HttpStatus.CREATED).body(Module);
	}

	@PutMapping("/module")
	public Object updateModule(@RequestBody ModuleInstalleParEntreprise Module) {
		Module = moduleInstalleParEntrepriseService.updateModuleInstalleParEntreprise( Module);
		return ResponseEntity.status(HttpStatus.CREATED).body(Module);
	}

	@DeleteMapping("/module/{idModule}")
	public Object deleteModule(@PathVariable("idModule") Long id) {
		moduleInstalleParEntrepriseService.deleteModuleInstalleParEntreprise(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	
	@PostMapping("/saveAllModule")
	public ResponseEntity<List<ModuleInstalleParEntreprise>> saveAllModuleInstalleParEntreprise(
			@RequestBody List<ModuleInstalleParEntreprise> ListModuleInstalleParEntreprise) {
		
		moduleInstalleParEntrepriseService.saveAll(ListModuleInstalleParEntreprise);
		return ResponseEntity.status(HttpStatus.CREATED).body(ListModuleInstalleParEntreprise);
	}
	
	@PostMapping("/saveAllDetailModule")
	public ResponseEntity<List<DetailModuleInstalleParEntreprise>> saveAllDetailModuleInstalleParEntreprise(
			@RequestBody List<DetailModuleInstalleParEntreprise> ListDetailModuleInstalleParEntreprise) {
		detailModuleInstalleParEntrepriseService.saveAll(ListDetailModuleInstalleParEntreprise);
		return ResponseEntity.status(HttpStatus.CREATED).body(ListDetailModuleInstalleParEntreprise);
	}
	


}


	

