package com.symatique.SmartSoft.services;

import java.util.List;

import com.symatique.SmartSoft.models.CategorieArticle;


public interface CategorieArticleService {
	
	CategorieArticle getCategorieArticle(Long id);

	List<CategorieArticle> getAllCategorieArticles();

	CategorieArticle saveCategorieArticle(CategorieArticle CategorieArticle);

	CategorieArticle updateCategorieArticle(CategorieArticle CategorieArticle);

	void deleteCategorieArticle(Long id);
		
	boolean checkLibelle(String libelle, Long idEntreprise);

}