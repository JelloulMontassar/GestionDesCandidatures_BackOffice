package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Candidat;

@Service
public interface CandidatService {
	
	Candidat getCandidat(Long id);

	List<Candidat> getAllCandidats();
		
	boolean checkLibelle(String libelle, Long idEntreprise);

	Candidat saveCandidat(Candidat candidat);

	Candidat updateCandidat(Candidat candidat);

	void deleteCandidat(Long id);

	Candidat getCandidatByUserID(Long id);
}
