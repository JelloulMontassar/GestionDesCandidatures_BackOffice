package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Departement;
import com.symatique.SmartSoft.repository.DepartementRepository;
import com.symatique.SmartSoft.services.DepartementService;


@org.springframework.stereotype.Service
public class DepartementServiceImpl implements DepartementService {

	@Autowired
	private DepartementRepository departementRepository;

	@Override
	public Departement getDepartement(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return departementRepository.findById(id).get();
	}

	@Override
	public List<Departement> getAllDepartements(Long id) {
		// TODO Auto-generated method stub
		return departementRepository.findAll().stream().filter(departement -> departement.isSupression() == false && departement.getIdEntreprise() == id).collect(Collectors.toList());		

	}

	@Override
	public Departement saveDepartement(Departement departement) {
		// TODO Auto-generated method stub
		return departementRepository.save(departement);
	}

	@Override
	public Departement updateDepartement( Departement departement) {
	
		return departementRepository.save(departement);
	}

	@Override
	public void deleteDepartement(Long id) {
		
		Departement departement = getDepartement(id);
		departement.setSupression(true);
		departementRepository.save(departement);

	}
	
	public boolean checkLibelleExists(String libelle,Long idEntreprise, Long id) {
	    // Recherche la puce avec le même numéro d'appel, en excluant celle avec l'id spécifié
	    Optional<Departement> existingDepartement = departementRepository.findByLibelleAndSupressionAndIdNotAndIdEntreprise(libelle, false, id, idEntreprise);

	    // Si une puce est trouvée, cela signifie que le numéro d'appel existe déjà
	    return existingDepartement.isPresent();
	  }
	
	
	public boolean checkLibelle(String libelle,Long idEntreprise) {
	    // Recherche la puce avec le même numéro d'appel, en excluant celle avec l'id spécifié
	    Optional<Departement> existingDepartement = departementRepository.findByLibelleAndSupressionAndIdEntreprise(libelle, false, idEntreprise);

	    // Si une puce est trouvée, cela signifie que le numéro d'appel existe déjà
	    return existingDepartement.isPresent();
	  }

}
