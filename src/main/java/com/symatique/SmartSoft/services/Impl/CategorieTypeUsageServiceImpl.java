package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.CategorieArticle;
import com.symatique.SmartSoft.models.CategorieTypeUsage;
import com.symatique.SmartSoft.repository.CategorieTypeUsagerRepository;
import com.symatique.SmartSoft.services.CategorieTypeUsageService;

@Service
@Transactional
public class CategorieTypeUsageServiceImpl implements CategorieTypeUsageService {

	@Autowired
    private CategorieTypeUsagerRepository categorieTypeUsageRepository;  


	
	@Override
	public CategorieTypeUsage getCategorieTypeUsage(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return categorieTypeUsageRepository.findById(id).get();
	}

	@Override
	public List<CategorieTypeUsage> getAllCategorieTypeUsages() {
		// TODO Auto-generated method stub
		return categorieTypeUsageRepository.findAll().stream().filter(CategorieTypeUsage -> CategorieTypeUsage.isSupression() == false).collect(Collectors.toList());		
	}

	@Override
	public CategorieTypeUsage saveCategorieTypeUsage(CategorieTypeUsage categorieTypeUsage) {
		// TODO Auto-generated method stub
		return categorieTypeUsageRepository.save(categorieTypeUsage);
	}

	@Override
	public CategorieTypeUsage updateCategorieTypeUsage( CategorieTypeUsage categorieTypeUsage) {
		return categorieTypeUsageRepository.save(categorieTypeUsage);
	}

	@Override
	public void deleteCategorieTypeUsage(Long id) {
		CategorieTypeUsage categorieTypeUsage = getCategorieTypeUsage(id);
		categorieTypeUsage.setSupression(true);
		categorieTypeUsageRepository.save(categorieTypeUsage);

	}
	
	@Override
	public boolean checkLibelle(String libelle, Long idEntreprise) {
		
		Optional<CategorieTypeUsage> existingCategorieTypeUsage = categorieTypeUsageRepository.findByLibelleAndSupressionAndIdEntreprise(libelle,
				false, idEntreprise);

		return existingCategorieTypeUsage.isPresent();
	}
	
	public boolean checkLibelleExists(String libelle,Long idEntreprise, Long id) {
	    // Recherche la puce avec le même numéro d'appel, en excluant celle avec l'id spécifié
	    Optional<CategorieTypeUsage> existingCategorieTypeUsage = categorieTypeUsageRepository.findByLibelleAndSupressionAndIdNotAndIdEntreprise(libelle, false, id, idEntreprise);
	    return existingCategorieTypeUsage.isPresent();
	  }
	
	
}
