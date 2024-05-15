package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.CategorieArticle;

import com.symatique.SmartSoft.repository.CategorieArticleRepository;
import com.symatique.SmartSoft.services.CategorieArticleService;


@Service
@Transactional
public class CategorieArticleServiceImpl implements CategorieArticleService {


	@Autowired
	private CategorieArticleRepository categorieArticleRepository;
	


	@Override
	public CategorieArticle getCategorieArticle(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return categorieArticleRepository.findById(id).get();
	}

	@Override
	public List<CategorieArticle> getAllCategorieArticles() {
		// TODO Auto-generated method stub
		return categorieArticleRepository.findAll().stream().filter(CategorieArticle -> CategorieArticle.isSupression() == false).collect(Collectors.toList());		
	}

	@Override
	public CategorieArticle saveCategorieArticle(CategorieArticle categorieArticle) {
		// TODO Auto-generated method stub
		return categorieArticleRepository.save(categorieArticle);
	}

	@Override
	public CategorieArticle updateCategorieArticle( CategorieArticle categorieArticle) {
		return categorieArticleRepository.save(categorieArticle);
	}

	@Override
	public void deleteCategorieArticle(Long id) {
		CategorieArticle categorieArticle = getCategorieArticle(id);
		categorieArticle.setSupression(true);
		categorieArticleRepository.save(categorieArticle);

	}
	
	@Override
	public boolean checkLibelle(String libelle, Long idEntreprise) {
		
		Optional<CategorieArticle> existingCategorieArticle = categorieArticleRepository.findByLibelleAndSupressionAndIdEntreprise(libelle,
				false, idEntreprise);

		return existingCategorieArticle.isPresent();
	}
	
	
}
