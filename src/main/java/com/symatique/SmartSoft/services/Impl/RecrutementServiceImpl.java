package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Recrutement;

import com.symatique.SmartSoft.repository.RecrutementRepository;
import com.symatique.SmartSoft.services.RecrutementService;


@Service
@Transactional
public class RecrutementServiceImpl implements RecrutementService {


	@Autowired
	private RecrutementRepository RecrutementRepository;
	


	@Override
	public Recrutement getRecrutement(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return RecrutementRepository.findById(id).get();
	}

	@Override
	public List<Recrutement> getAllRecrutements() {
		// TODO Auto-generated method stub
		return RecrutementRepository.findAll().stream().filter(Recrutement -> Recrutement.isSupression() == false).collect(Collectors.toList());		
	}

	@Override
	public Recrutement saveRecrutement(Recrutement Recrutement) {
		// TODO Auto-generated method stub
		return RecrutementRepository.save(Recrutement);
	}

	@Override
	public Recrutement updateRecrutement( Recrutement Recrutement) {
		return RecrutementRepository.save(Recrutement);
	}
	

	@Override
	public void deleteRecrutement(Long id) {
		Recrutement Recrutement = getRecrutement(id);
		Recrutement.setSupression(true);
		RecrutementRepository.save(Recrutement);

	}
	
	@Override
	public boolean checkLibelle(String libelle, Long idEntreprise) {
		
		Optional<Recrutement> existingRecrutement = RecrutementRepository.findByLibelleAndSupressionAndIdEntreprise(libelle,
				false, idEntreprise);

		return existingRecrutement.isPresent();
	}



	
	
}
