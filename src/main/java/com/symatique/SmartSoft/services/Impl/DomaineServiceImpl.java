package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Domaine;
import com.symatique.SmartSoft.repository.DomaineRepository;
import com.symatique.SmartSoft.services.DomaineService;

@Service
public class DomaineServiceImpl implements DomaineService {

	@Autowired
	private DomaineRepository domaineRepository;

	@Override
	public Domaine getDomaine(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return domaineRepository.findById(id).get();
	}

	@Override
	public List<Domaine> getAllDomaines() {
		// TODO Auto-generated method stub
		return domaineRepository.findAll().stream().filter(domaine -> domaine.isSupression() == false).collect(Collectors.toList());		
	}

	@Override
	public Domaine saveDomaine(Domaine domaine) {
		// TODO Auto-generated method stub
		return domaineRepository.save(domaine);
	}

	@Override
	public Domaine updateDomaine( Domaine domaine) {
		//getDomaine(id);
		// tempsReel.setId(id);
		return domaineRepository.save(domaine);
	}

	@Override
	public void deleteDomaine(Long id) {
		Domaine domaine = getDomaine(id);
		domaine.setSupression(true);
		domaineRepository.save(domaine);

	}
	
	public boolean checkLibelleExists(String libelle ,Long idEntreprise , Long id) {
	    // Recherche la puce avec le même numéro d'appel, en excluant celle avec l'id spécifié
	    Optional<Domaine> existingDomaine = domaineRepository.findByLibelleAndSupressionAndIdNotAndEntrepriseId(libelle, false, id, idEntreprise);

	    // Si une puce est trouvée, cela signifie que le numéro d'appel existe déjà
	    return existingDomaine.isPresent();
	  }
	
	
	public boolean checkLibelle(String libelle,Long idEntreprise) {
	    // Recherche la puce avec le même numéro d'appel, en excluant celle avec l'id spécifié
	    Optional<Domaine> existingDomaine = domaineRepository.findByLibelleAndSupressionAndEntrepriseId(libelle, false, idEntreprise);

	    // Si une puce est trouvée, cela signifie que le numéro d'appel existe déjà
	    return existingDomaine.isPresent();
	  }
	

}
