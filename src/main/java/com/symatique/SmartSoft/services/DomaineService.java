package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Domaine;

@Service
public interface DomaineService {

	Domaine getDomaine(Long id);

	List<Domaine> getAllDomaines();

	Domaine saveDomaine(Domaine domaine);

	Domaine updateDomaine(Domaine domaine);

	void deleteDomaine(Long id);

	boolean checkLibelleExists(String libelle, Long idEntreprise, Long id);
	
	boolean checkLibelle(String libelle,Long idEntreprise);

}
