package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.StatusCandidature;

import com.symatique.SmartSoft.repository.StatusCandidatureRepository;
import com.symatique.SmartSoft.services.StatusCandidatureService;


@Service
@Transactional
public class StatusCandidatureServiceImpl implements StatusCandidatureService {


	@Autowired
	private StatusCandidatureRepository StatusCandidatureRepository;
	


	@Override
	public StatusCandidature getStatusCandidature(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return StatusCandidatureRepository.findById(id).get();
	}

	@Override
	public List<StatusCandidature> getAllStatusCandidatures() {
		// TODO Auto-generated method stub
		return StatusCandidatureRepository.findAll().stream().filter(StatusCandidature -> StatusCandidature.isSupression() == false).collect(Collectors.toList());		
	}

	@Override
	public StatusCandidature saveStatusCandidature(StatusCandidature StatusCandidature) {
		// TODO Auto-generated method stub
		return StatusCandidatureRepository.save(StatusCandidature);
	}

	@Override
	public StatusCandidature updateStatusCandidature( StatusCandidature StatusCandidature) {
		return StatusCandidatureRepository.save(StatusCandidature);
	}
	

	@Override
	public void deleteStatusCandidature(Long id) {
		StatusCandidature StatusCandidature = getStatusCandidature(id);
		StatusCandidature.setSupression(true);
		StatusCandidatureRepository.save(StatusCandidature);

	}
	
	@Override
	public boolean checkLibelle(String libelle, Long idEntreprise) {
		
		Optional<StatusCandidature> existingStatusCandidature = StatusCandidatureRepository.findByLibelleAndSupressionAndIdEntreprise(libelle,
				false, idEntreprise);

		return existingStatusCandidature.isPresent();
	}



	
	
}
