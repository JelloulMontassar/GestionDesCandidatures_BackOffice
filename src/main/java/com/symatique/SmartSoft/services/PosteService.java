package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Poste;

@Service
public interface PosteService {

	Poste getPoste(Long id);

	List<Poste> getAllPostes();

	Poste savePoste(Poste poste);

	Poste updatePoste( Poste poste);

	void deletePoste(Long id);
	
	boolean checkLibelleExists(String libelle, Long idEntreprise, Long id);
	
	boolean checkLibelle(String libelle,Long idEntreprise);
	
	

}
