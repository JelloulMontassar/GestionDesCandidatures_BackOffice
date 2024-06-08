package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Offre;

import com.symatique.SmartSoft.repository.OffreRepository;
import com.symatique.SmartSoft.services.OffreService;


@Service
@Transactional
public class OffreServiceImpl implements OffreService {


	@Autowired
	private OffreRepository OffreRepository;
	


	@Override
	public Offre getOffre(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return OffreRepository.findById(id).get();
	}

	@Override
	public List<Offre> getAllOffres() {
		// TODO Auto-generated method stub
		return OffreRepository.findAll().stream().filter(Offre -> Offre.isSupression() == false).collect(Collectors.toList());		
	}

	@Override
	public Offre saveOffre(Offre Offre) {
		// TODO Auto-generated method stub
		return OffreRepository.save(Offre);
	}

	@Override
	public Offre updateOffre( Offre Offre) {
		return OffreRepository.save(Offre);
	}
	

	@Override
	public void deleteOffre(Long id) {
		Offre Offre = getOffre(id);
		Offre.setSupression(true);
		OffreRepository.save(Offre);

	}
	
	@Override
	public boolean checkLibelle(String libelle, Long idEntreprise) {
		
		Optional<Offre> existingOffre = OffreRepository.findByLibelleAndSupressionAndIdEntreprise(libelle,
				false, idEntreprise);

		return existingOffre.isPresent();
	}
	@Override
	public List<Offre> searchOffres(String libelle, String localisation, String description) {
		return OffreRepository.searchOffres(libelle, localisation, description);
	}



	
	
}
