package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Candidature;

@Service
public interface CandidatureService {
	
	Candidature getCandidature(Long id);

	List<Candidature> getAllCandidatures();

	Candidature saveCandidature(Candidature Candidature);

	Candidature updateCandidature(Candidature Candidature);

	void deleteCandidature(Long id);
		
	boolean checkLibelle(String libelle, Long idEntreprise);
	

}