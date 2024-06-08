package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Offre;

@Service
public interface OffreService {
	
	Offre getOffre(Long id);

	List<Offre> getAllOffres();

	Offre saveOffre(Offre Offre);

	Offre updateOffre(Offre Offre);

	void deleteOffre(Long id);
		
	boolean checkLibelle(String libelle, Long idEntreprise);
	List<Offre> searchOffres(String libelle, String localisation, String description);

}
