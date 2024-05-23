package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Entretien;

@Service
public interface EntretienService {
	
	Entretien getEntretien(Long id);

	List<Entretien> getAllEntretiens();

	Entretien saveEntretien(Entretien Entretien);

	Entretien updateEntretien(Entretien Entretien);

	void deleteEntretien(Long id);
		
	boolean checkLibelle(String libelle, Long idEntreprise);

}