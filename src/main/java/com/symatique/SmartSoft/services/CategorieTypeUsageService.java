package com.symatique.SmartSoft.services;

import java.util.List;

import com.symatique.SmartSoft.models.CategorieTypeUsage;

public interface CategorieTypeUsageService {

	CategorieTypeUsage getCategorieTypeUsage(Long id);

	List<CategorieTypeUsage> getAllCategorieTypeUsages();

	CategorieTypeUsage saveCategorieTypeUsage(CategorieTypeUsage CategorieTypeUsage);

	CategorieTypeUsage updateCategorieTypeUsage(CategorieTypeUsage CategorieTypeUsage);

	void deleteCategorieTypeUsage(Long id);
	
	boolean checkLibelle(String libelle, Long idEntreprise);

	boolean checkLibelleExists(String libelle, Long idEntreprise, Long id);

}
