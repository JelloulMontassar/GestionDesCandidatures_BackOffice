package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Entreprise;
import com.symatique.SmartSoft.repository.EntrepriseRepository;
import com.symatique.SmartSoft.services.EntrepriseService;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {

	@Autowired
	private EntrepriseRepository entrepriseRepository;

	@Override
	public Entreprise getEntreprise(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return entrepriseRepository.findById(id).get();
	}

	@Override
	public List<Entreprise> getAllEntreprises() {
		// TODO Auto-generated method stub
		return entrepriseRepository.findAll().stream().filter(entreprise -> entreprise.isSupression() == false).collect(Collectors.toList());		

	}

	@Override
	public Entreprise saveEntreprise(Entreprise entreprise) {
		// TODO Auto-generated method stub
		return entrepriseRepository.save(entreprise);
	}

	@Override
	public Entreprise updateEntreprise( Entreprise entreprise) {
		return entrepriseRepository.save(entreprise);
	}

	@Override
	public void deleteEntreprise(Long id) {
		Entreprise entreprise = getEntreprise(id);
		 entreprise.setSupression(true);
		entrepriseRepository.save(entreprise);

	}
	
	public boolean checkLibelleExists(String libelle, Long id) {
	    // Recherche la puce avec le même numéro d'appel, en excluant celle avec l'id spécifié
	    Optional<Entreprise> existingEntreprise = entrepriseRepository.findByLibelleAndSupressionAndIdNot(libelle, false, id);

	    // Si une puce est trouvée, cela signifie que le numéro d'appel existe déjà
	    return existingEntreprise.isPresent();
	  }
	
	
	public boolean checkLibelle(String libelle) {
	    // Recherche la puce avec le même numéro d'appel, en excluant celle avec l'id spécifié
	    Optional<Entreprise> existingEntreprise = entrepriseRepository.findByLibelleAndSupression(libelle, false);

	    // Si une puce est trouvée, cela signifie que le numéro d'appel existe déjà
	    return existingEntreprise.isPresent();
	  }
	
	

}
