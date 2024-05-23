package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Calendrier;

@Service
public interface CalendrierService {
	
	Calendrier getCalendrier(Long id);

	List<Calendrier> getAllCalendriers();

	Calendrier saveCalendrier(Calendrier Calendrier);

	Calendrier updateCalendrier(Calendrier Calendrier);

	void deleteCalendrier(Long id);
		
	boolean checkLibelle(String libelle, Long idEntreprise);

}