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

import com.symatique.SmartSoft.DTO.ArticleDTO;
import com.symatique.SmartSoft.models.Article;
import com.symatique.SmartSoft.models.CategorieArticle;
import com.symatique.SmartSoft.services.ArticleService;
import com.symatique.SmartSoft.services.CategorieArticleService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ArticleController {

	private ArticleService articleService;
	private CategorieArticleService categorieArticleService;
	@Autowired
	private ModelMapper modelMapper ;

	 @Autowired
	    public ArticleController(ArticleService articleService, CategorieArticleService categorieArticleService) {
	        this.articleService = articleService;
	        this.categorieArticleService = categorieArticleService;
	    }
	
	@GetMapping("/allArticle")
	public ResponseEntity<List<ArticleDTO>> listArticle(@RequestParam Long id) {
	    List<Article> articles = articleService.getAllArticles().stream()
	            .filter(e -> e.getIdEntreprise().equals(id) && !e.isSupression())
	            .collect(Collectors.toList());

	    List<ArticleDTO> listArticleDTO = new ArrayList<>();
	    for (Article article : articles) {
	        ArticleDTO articleDTO = modelMapper.map(article, ArticleDTO.class);
	        listArticleDTO.add(articleDTO);
	    }

	    return ResponseEntity.status(HttpStatus.OK).body(listArticleDTO);
	}

	@GetMapping("/Article/{idArticle}")
	public ResponseEntity<ArticleDTO> getArticle(@PathVariable("idArticle") Long id) {
	    Article article = articleService.getArticle(id);
	    ArticleDTO articleDTO = modelMapper.map(article, ArticleDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(articleDTO);
	   
	}


	@PostMapping("/Article")
	public ResponseEntity<Article> saveArticle(@RequestBody Article article) {
		articleService.saveArticle(article);
		return ResponseEntity.status(HttpStatus.CREATED).body(article);
	}

	@PutMapping("/Article")
	public Object updateArticle(@RequestBody Article article) {
		article = articleService.updateArticle(article);
		return ResponseEntity.status(HttpStatus.CREATED).body(article);
	}

	 @PutMapping("/Article/{id}/suppression")
	    public ResponseEntity<Article> updateSuppression(@PathVariable Long id) {
	        Article article = articleService.getArticle(id);

	        article.setSupression(true);

	        Article updatedArticle = articleService.saveArticle(article);
	        return ResponseEntity.ok(updatedArticle);
	    }
	 
	@DeleteMapping("/Article/{idArticle}")
	public Object deleteArticle(@PathVariable("idArticle") Long id) {
		articleService.deleteArticle(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/article/verifierLibelle")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String libelle, @RequestParam Long idEntreprise) {
		boolean exist = articleService.checkLibelle(libelle,idEntreprise);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}
	
	
	@PutMapping("/article/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") Long id, @RequestBody Article updatedArticle) {
        Article existingArticle = articleService.getArticle(id);

        if (existingArticle != null) {
            // Update basic article properties
            existingArticle.setLibelle(updatedArticle.getLibelle());
            existingArticle.setDescription(updatedArticle.getDescription());
            existingArticle.setReference(updatedArticle.getReference());
            existingArticle.setDateCreation(updatedArticle.getDateCreation());

            // Update category
            CategorieArticle updatedCategory = updatedArticle.getCategorieArticle();
            if (updatedCategory != null) {

            	CategorieArticle existingCategory = categorieArticleService.getCategorieArticle(updatedCategory.getId());
                
                // Update category properties
                if (existingCategory != null) {
                    existingArticle.setCategorieArticle(existingCategory);
                } else {
                    // Handle category not found error
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }
            }

            // Save the updated article
            articleService.saveArticle(existingArticle);

            return ResponseEntity.status(HttpStatus.OK).body(existingArticle);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
	
	
	
	/*
	@GetMapping("/articles")
	public List<Article> rechercheArticles(@RequestParam(required = false) Long centreId,
			@RequestParam(required = false) Long batimentId,
		    @RequestParam(required = false) Long idEntreprise) {
		
		
		if (centreId == 0) {
			centreId = null;
		}
		
		if (batimentId == 0) {
			batimentId = null;
		}
		
		return articleService.findArticleByAttributes(centreId, batimentId).stream()
				.filter(e -> e.getIdEntreprise() == idEntreprise && !e.isSuppression())
				.collect(Collectors.toList());
	}
*/
	
	
	
	
}
