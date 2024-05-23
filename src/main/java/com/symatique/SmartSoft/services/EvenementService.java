package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Evenement;

@Service
public interface EvenementService {
	
	Evenement getEvenement(Long id);

	List<Evenement> getAllEvenements();

	Evenement saveEvenement(Evenement Evenement);

	Evenement updateEvenement(Evenement Evenement);

	void deleteEvenement(Long id);
		
	boolean checkLibelle(String libelle, Long idEntreprise);

}