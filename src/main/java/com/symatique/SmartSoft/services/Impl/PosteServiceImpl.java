package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Poste;
import com.symatique.SmartSoft.repository.PosteRepository;
import com.symatique.SmartSoft.services.PosteService;

@Service
public class PosteServiceImpl implements PosteService {

	@Autowired
	private PosteRepository posteRepository;

	@Override
	public Poste getPoste(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return posteRepository.findById(id).get();
	}

	@Override
	public List<Poste> getAllPostes() {
		// TODO Auto-generated method stub
		return posteRepository.findAll().stream().filter(poste -> poste.isSupression() == false).collect(Collectors.toList());		

	}

	@Override
	public Poste savePoste(Poste poste) {
		// TODO Auto-generated method stub
		return posteRepository.save(poste);
	}

	@Override
	public Poste updatePoste( Poste poste) {
		
		// tempsReel.setId(id);
		return posteRepository.save(poste);
	}

	@Override
	public void deletePoste(Long id) {
		Poste poste = getPoste(id);
		poste.setSupression(true);
		posteRepository.save(poste);
	}
	
	public boolean checkLibelleExists(String libelle ,Long idEntreprise , Long id) {
	    // Recherche la puce avec le même numéro d'appel, en excluant celle avec l'id spécifié
	    Optional<Poste> existingPoste = posteRepository.findByLibelleAndSupressionAndIdNotAndIdEntreprise(libelle, false, id, idEntreprise);

	    // Si une puce est trouvée, cela signifie que le numéro d'appel existe déjà
	    return existingPoste.isPresent();
	  }
	
	
	public boolean checkLibelle(String libelle,Long idEntreprise) {
	    // Recherche la puce avec le même numéro d'appel, en excluant celle avec l'id spécifié
	    Optional<Poste> existingPoste = posteRepository.findByLibelleAndSupressionAndIdEntreprise(libelle, false, idEntreprise);

	    // Si une puce est trouvée, cela signifie que le numéro d'appel existe déjà
	    return existingPoste.isPresent();
	  }
	
	

}
