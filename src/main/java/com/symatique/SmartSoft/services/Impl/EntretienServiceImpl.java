package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Entretien;
import com.symatique.SmartSoft.repository.EntretienRepository;
import com.symatique.SmartSoft.services.EntretienService;


@Service
@Transactional
public class EntretienServiceImpl implements EntretienService {


	@Autowired
	private EntretienRepository EntretienRepository;
	


	@Override
	public Entretien getEntretien(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return EntretienRepository.findById(id).get();
	}

	@Override
	public List<Entretien> getAllEntretiens() {
		// TODO Auto-generated method stub
		return EntretienRepository.findAll().stream().filter(Entretien -> Entretien.isSupression() == false).collect(Collectors.toList());		
	}

	@Override
	public Entretien saveEntretien(Entretien Entretien) {
		// TODO Auto-generated method stub
		return EntretienRepository.save(Entretien);
	}
	
	

	@Override
	public Entretien updateEntretien( Entretien Entretien) {
		return EntretienRepository.save(Entretien);
	}

	@Override
	public void deleteEntretien(Long id) {
		Entretien Entretien = getEntretien(id);
		Entretien.setSupression(true);
		EntretienRepository.save(Entretien);

	}
	
	@Override
	public boolean checkLibelle(String libelle, Long idEntreprise) {
		
		Optional<Entretien> existingEntretien = EntretienRepository.findByLibelleAndSupressionAndIdEntreprise(libelle,
				false, idEntreprise);

		return existingEntretien.isPresent();
	}
	
	
}
