package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Entreprise;

@Service
public interface EntrepriseService {

	Entreprise getEntreprise(Long id);

	List<Entreprise> getAllEntreprises();

	Entreprise saveEntreprise(Entreprise entreprise);

	Entreprise updateEntreprise( Entreprise entreprise);

	void deleteEntreprise(Long id);
	
	boolean checkLibelleExists(String libelle, Long id);
	
	boolean checkLibelle(String libelle);

}
