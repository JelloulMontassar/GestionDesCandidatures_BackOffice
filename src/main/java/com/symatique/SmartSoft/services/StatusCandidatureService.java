package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.StatusCandidature;

@Service
public interface StatusCandidatureService {
	
	StatusCandidature getStatusCandidature(Long id);

	List<StatusCandidature> getAllStatusCandidatures();

	StatusCandidature saveStatusCandidature(StatusCandidature StatusCandidature);

	StatusCandidature updateStatusCandidature(StatusCandidature StatusCandidature);

	void deleteStatusCandidature(Long id);
		
	boolean checkLibelle(String libelle, Long idEntreprise);

}