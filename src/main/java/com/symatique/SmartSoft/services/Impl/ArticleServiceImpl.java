package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Article;
import com.symatique.SmartSoft.repository.ArticleRepository;
import com.symatique.SmartSoft.services.ArticleService;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
    private ArticleRepository articleRepository;
	
	
	@Override
	public Article getArticle(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return articleRepository.findById(id).get();
	}

	@Override
	public List<Article> getAllArticles() {
		// TODO Auto-generated method stub
		return articleRepository.findAll().stream().filter(Article -> Article.isSupression() == false).collect(Collectors.toList());		
	}

	@Override
	public Article saveArticle(Article Article) {
		// TODO Auto-generated method stub
		return articleRepository.save(Article);
	}

	@Override
	public Article updateArticle( Article article) {
		return articleRepository.save(article);
	}

	@Override
	public void deleteArticle(Long id) {
		Article article = getArticle(id);
		article.setSupression(true);
		articleRepository.save(article);

	}
	
	
	@Override
	public boolean checkLibelle(String libelle, Long idEntreprise) {
		
		Optional<Article> existingArticle = articleRepository.findByLibelleAndSupressionAndIdEntreprise(libelle,
				false, idEntreprise);

		return existingArticle.isPresent();
	}
	
	/*@Override
	public List<Article> findArticleByAttributes(Long centreId, Long batimentId) {
		 return articleRepository.findArticleByAttributes(centreId, batimentId);
	}*/
	

}