package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Evenement;
import com.symatique.SmartSoft.repository.EvenementRepository;
import com.symatique.SmartSoft.services.EvenementService;


@Service
@Transactional
public class EvenementServiceImpl implements EvenementService {


	@Autowired
	private EvenementRepository EvenementRepository;
	


	@Override
	public Evenement getEvenement(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return EvenementRepository.findById(id).get();
	}

	@Override
	public List<Evenement> getAllEvenements() {
		// TODO Auto-generated method stub
		return EvenementRepository.findAll().stream().filter(Evenement -> Evenement.isSupression() == false).collect(Collectors.toList());		
	}

	@Override
	public Evenement saveEvenement(Evenement Evenement) {
		// TODO Auto-generated method stub
		return EvenementRepository.save(Evenement);
	}
	
	

	@Override
	public Evenement updateEvenement( Evenement Evenement) {
		return EvenementRepository.save(Evenement);
	}

	@Override
	public void deleteEvenement(Long id) {
		Evenement Evenement = getEvenement(id);
		Evenement.setSupression(true);
		EvenementRepository.save(Evenement);

	}
	
	@Override
	public boolean checkLibelle(String libelle, Long idEntreprise) {
		
		Optional<Evenement> existingEvenement = EvenementRepository.findByLibelleAndSupressionAndIdEntreprise(libelle,
				false, idEntreprise);

		return existingEvenement.isPresent();
	}
	
	
}
