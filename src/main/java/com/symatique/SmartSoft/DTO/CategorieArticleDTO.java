package com.symatique.SmartSoft.DTO;

import java.util.List;

import com.symatique.SmartSoft.models.Article;

import lombok.Data;

@Data
public class CategorieArticleDTO {
	
	private Long id;

	private String libelle;

	private String description;
	
	private boolean supression ;
	
    private Long idEntreprise;
	
	private String libelleEntreprise;
	
	private List<Article> ListArticle;


}