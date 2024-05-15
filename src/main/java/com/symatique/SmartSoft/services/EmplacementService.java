package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Emplacement;

@Service
public interface EmplacementService {
	
	Emplacement getEmplacement(Long id);

	List<Emplacement> getAllEmplacements();

	Emplacement saveEmplacement(Emplacement emplacement);

	Emplacement updateEmplacement(Emplacement emplacement);

	void deleteEmplacement(Long id);
	
	boolean checkLibelleExists(String libelle, Long idEntreprise, Long id);
	
	boolean checkLibelle(String libelle,Long idEntreprise);
	
	boolean modifierLibelleEmplacement( String oldLibelle ,String newLibelle);
	
	boolean verifierExistsDetails(String libelle);


}
