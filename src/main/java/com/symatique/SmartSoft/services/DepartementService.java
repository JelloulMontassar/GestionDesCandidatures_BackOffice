package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Departement;


@Service
public interface DepartementService {
	
	Departement getDepartement(Long id);

	List<Departement> getAllDepartements(Long id);

	Departement saveDepartement(Departement departement);

	Departement updateDepartement(Departement departement);

	void deleteDepartement(Long id);
	
	boolean checkLibelleExists(String libelle, Long idEntreprise, Long id);
	
	boolean checkLibelle(String libelle, Long idEntreprise);

}
