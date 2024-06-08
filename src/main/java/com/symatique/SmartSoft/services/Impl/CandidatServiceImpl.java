package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Candidat;

import com.symatique.SmartSoft.repository.CandidatRepository;
import com.symatique.SmartSoft.services.CandidatService;


@Service
@Transactional
public class CandidatServiceImpl implements CandidatService {


	@Autowired
	private CandidatRepository candidatRepository;
	


	@Override
	public Candidat getCandidat(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return candidatRepository.findById(id).get();
	}

	@Override
	public List<Candidat> getAllCandidats() {
		// TODO Auto-generated method stub
		return candidatRepository.findAll().stream().filter(Candidat -> Candidat.isSupression() == false).collect(Collectors.toList());		
	}

	@Override
	public Candidat saveCandidat(Candidat candidat) {
		// TODO Auto-generated method stub
		return candidatRepository.save(candidat);
	}

	@Override
	public Candidat updateCandidat( Candidat candidat) {
		return candidatRepository.save(candidat);
	}
	

	@Override
	public void deleteCandidat(Long id) {
		Candidat candidat = getCandidat(id);
		candidat.setSupression(true);
		candidatRepository.save(candidat);

	}

	@Override
	public Candidat getCandidatByUserID(Long id) {
		return  candidatRepository.findByUtilisateurId(id);
	}

	@Override
	public boolean checkLibelle(String libelle, Long idEntreprise) {
		
		Optional<Candidat> existingCandidat = candidatRepository.findByLibelleAndSupressionAndIdEntreprise(libelle,
				false, idEntreprise);

		return existingCandidat.isPresent();
	}



	
	
}
