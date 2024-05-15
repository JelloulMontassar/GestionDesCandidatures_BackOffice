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

import com.symatique.SmartSoft.models.CategorieArticle;
import com.symatique.SmartSoft.models.CategorieTypeUsage;
import com.symatique.SmartSoft.services.CategorieTypeUsageService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CategorieTypeUsageController {

    @Autowired
    private CategorieTypeUsageService categorieTypeUsageService;

    @GetMapping("/allCategorieTypeUsage")
	public ResponseEntity<List<CategorieTypeUsage>> ListCategorieTypeUsage(@RequestParam Long id) {
		List<CategorieTypeUsage> categorieTypeUsages = categorieTypeUsageService.getAllCategorieTypeUsages().stream().filter(e -> e.getIdEntreprise() == id && !e.isSupression()).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(categorieTypeUsages);
	}

	@GetMapping("/CategorieTypeUsage/{idCategorieTypeUsage}")
	public ResponseEntity<CategorieTypeUsage> getCategorieTypeUsage(@PathVariable("idCategorieTypeUsage") Long id) {
		CategorieTypeUsage categorieTypeUsage = categorieTypeUsageService.getCategorieTypeUsage(id);
		return ResponseEntity.status(HttpStatus.OK).body(categorieTypeUsage);
	}

	@PostMapping("/CategorieTypeUsage")
	public ResponseEntity<CategorieTypeUsage> saveCategorieTypeUsage(@RequestBody CategorieTypeUsage categorieTypeUsage) {
		categorieTypeUsageService.saveCategorieTypeUsage(categorieTypeUsage);
		return ResponseEntity.status(HttpStatus.CREATED).body(categorieTypeUsage);
	}

	@PutMapping("/CategorieTypeUsage")
	public Object updateCategorieTypeUsage(@RequestBody CategorieTypeUsage categorieTypeUsage) {
		categorieTypeUsage = categorieTypeUsageService.updateCategorieTypeUsage(categorieTypeUsage);
		return ResponseEntity.status(HttpStatus.CREATED).body(categorieTypeUsage);
	}
	
	@PutMapping("/CategorieTypeUsage/{id}/suppression")
    public ResponseEntity<CategorieTypeUsage> updateSuppression(@PathVariable Long id) {
		CategorieTypeUsage categorieTypeUsage = categorieTypeUsageService.getCategorieTypeUsage(id);

		categorieTypeUsage.setSupression(true);

	 	CategorieTypeUsage updatedCategorieTypeUsage = categorieTypeUsageService.saveCategorieTypeUsage(categorieTypeUsage);
        return ResponseEntity.ok(updatedCategorieTypeUsage);
    }

	@DeleteMapping("/CategorieTypeUsage/{idCategorieTypeUsage}")
	public Object deleteCategorieTypeUsage(@PathVariable("idCategorieTypeUsage") Long id) {
		categorieTypeUsageService.deleteCategorieTypeUsage(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/categorieusage/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {
		boolean exist = categorieTypeUsageService.checkLibelle(libelle,idEntreprise);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	
	@GetMapping("/CategorieTypeUsage/verifierLibelleId")
	public ResponseEntity<Boolean> checkLibelleExists(@RequestParam String libelle, @RequestParam Long idEntreprise, @RequestParam Long id) {
		boolean exist = categorieTypeUsageService.checkLibelleExists(libelle,idEntreprise, id);

		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	
}
