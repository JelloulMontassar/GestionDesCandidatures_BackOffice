package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Candidature;
import com.symatique.SmartSoft.repository.CandidatureRepository;
import com.symatique.SmartSoft.services.CandidatureService;


@Service
@Transactional
public class CandidatureServiceImpl implements CandidatureService {


	@Autowired
	private CandidatureRepository candidatureRepository;
	


	@Override
	public Candidature getCandidature(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return candidatureRepository.findById(id).get();
	}

	@Override
	public List<Candidature> getAllCandidatures() {
		// TODO Auto-generated method stub
		return candidatureRepository.findAll();
	}

	@Override
	public Candidature saveCandidature(Candidature candidature) {
		// TODO Auto-generated method stub
		return candidatureRepository.save(candidature);
	}
	
	

	@Override
	public Candidature updateCandidature( Candidature candidature) {
		return candidatureRepository.save(candidature);
	}

	@Override
	public void deleteCandidature(Long id) {
		Candidature candidature = getCandidature(id);
		candidature.setSupression(true);
		candidatureRepository.save(candidature);

	}
	
	@Override
	public boolean checkLibelle(String libelle, Long idEntreprise) {
		
		Optional<Candidature> existingCandidature = candidatureRepository.findByLibelleAndSupressionAndIdEntreprise(libelle,
				false, idEntreprise);

		return existingCandidature.isPresent();
	}

	@Override
	public List<Candidature> getCandidatureByCandidat(Long id) {
		return candidatureRepository.findByCandidatId(id);
	}


}
