package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Article;


@Service
public interface ArticleService {

	Article getArticle(Long id);

	List<Article> getAllArticles();

	Article saveArticle(Article Article);

	Article updateArticle(Article Article);

	void deleteArticle(Long id);
	
	/*List<Article> findArticleByAttributes(Long centreId, Long batimentId);*/

	boolean checkLibelle(String libelle, Long idEntreprise);


}