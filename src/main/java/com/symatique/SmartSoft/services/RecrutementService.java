package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Recrutement;

@Service
public interface RecrutementService {
	
	Recrutement getRecrutement(Long id);

	List<Recrutement> getAllRecrutements();

	Recrutement saveRecrutement(Recrutement Recrutement);

	Recrutement updateRecrutement(Recrutement Recrutement);

	void deleteRecrutement(Long id);
		
	boolean checkLibelle(String libelle, Long idEntreprise);

}