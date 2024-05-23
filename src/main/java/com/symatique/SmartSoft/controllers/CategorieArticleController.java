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
import com.symatique.SmartSoft.services.CategorieArticleService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CategorieArticleController {


	@Autowired
	private CategorieArticleService categorieArticleService;
	
	@GetMapping("/allCategorieArticle")
	public ResponseEntity<List<CategorieArticle>> ListCategorieArticle(@RequestParam Long id) {
		List<CategorieArticle> categorieArticles = categorieArticleService.getAllCategorieArticles().stream().filter(e -> e.getIdEntreprise() == id && !e.isSupression()).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(categorieArticles);
	}

	@GetMapping("/CategorieArticle/{idCategorieArticle}")
	public ResponseEntity<CategorieArticle> getCategorieArticle(@PathVariable("idCategorieArticle") Long id) {
		CategorieArticle categorieArticle = categorieArticleService.getCategorieArticle(id);
		return ResponseEntity.status(HttpStatus.OK).body(categorieArticle);
	}

	@PostMapping("/CategorieArticle")
	public ResponseEntity<CategorieArticle> saveCategorieArticle(@RequestBody CategorieArticle categorieArticle) {
		categorieArticleService.saveCategorieArticle(categorieArticle);
		return ResponseEntity.status(HttpStatus.CREATED).body(categorieArticle);
	}

	@PutMapping("/CategorieArticle")
	public Object updateCategorieArticle(@RequestBody CategorieArticle categorieArticle) {
		categorieArticle = categorieArticleService.updateCategorieArticle(categorieArticle);
		return ResponseEntity.status(HttpStatus.CREATED).body(categorieArticle);
	}
	
	 @PutMapping("/CategorieArticle/{id}/suppression")
	    public ResponseEntity<CategorieArticle> updateSuppression(@PathVariable Long id) {
		 	CategorieArticle categorieArticle = categorieArticleService.getCategorieArticle(id);

		 	categorieArticle.setSupression(true);

	        CategorieArticle updatedCategorieArticle = categorieArticleService.saveCategorieArticle(categorieArticle);
	        return ResponseEntity.ok(updatedCategorieArticle);
	    }

	@DeleteMapping("/CategorieArticle/{idCategorieArticle}")
	public Object deleteCategorieArticle(@PathVariable("idCategorieArticle") Long id) {
		categorieArticleService.deleteCategorieArticle(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/CategorieArticle/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {
		boolean exist = categorieArticleService.checkLibelle(libelle,idEntreprise);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

	
	
}
