package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Calendrier;
import com.symatique.SmartSoft.repository.CalendrierRepository;
import com.symatique.SmartSoft.services.CalendrierService;


@Service
@Transactional
public class CalendrierServiceImpl implements CalendrierService {


	@Autowired
	private CalendrierRepository CalendrierRepository;
	


	@Override
	public Calendrier getCalendrier(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return CalendrierRepository.findById(id).get();
	}

	@Override
	public List<Calendrier> getAllCalendriers() {
		// TODO Auto-generated method stub
		return CalendrierRepository.findAll().stream().filter(Calendrier -> Calendrier.isSupression() == false).collect(Collectors.toList());		
	}

	@Override
	public Calendrier saveCalendrier(Calendrier Calendrier) {
		// TODO Auto-generated method stub
		return CalendrierRepository.save(Calendrier);
	}
	
	

	@Override
	public Calendrier updateCalendrier( Calendrier Calendrier) {
		return CalendrierRepository.save(Calendrier);
	}

	@Override
	public void deleteCalendrier(Long id) {
		Calendrier Calendrier = getCalendrier(id);
		Calendrier.setSupression(true);
		CalendrierRepository.save(Calendrier);

	}
	
	@Override
	public boolean checkLibelle(String libelle, Long idEntreprise) {
		
		Optional<Calendrier> existingCalendrier = CalendrierRepository.findByLibelleAndSupressionAndIdEntreprise(libelle,
				false, idEntreprise);

		return existingCalendrier.isPresent();
	}
	
	
}
