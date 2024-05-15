package com.symatique.SmartSoft.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Gouvernorat;
import com.symatique.SmartSoft.repository.GouvernoratRepository;
import com.symatique.SmartSoft.services.GouvernoratService;

@Service
public class GouvernoratServiceImpl implements GouvernoratService{

	@Autowired
	private GouvernoratRepository gouvernoratRepository;
	
	@Override
	public Gouvernorat getGouvernorat(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return gouvernoratRepository.findById(id).get();
	}

	@Override
	public List<Gouvernorat> getAllGouvernorats() {
		// TODO Auto-generated method stub
		return gouvernoratRepository.findAll();
	}

	@Override
	public Gouvernorat saveGouvernorat(Gouvernorat gouvernorat) {
		// TODO Auto-generated method stub
		return gouvernoratRepository.save(gouvernorat);
	}

	@Override
	public Gouvernorat updateGouvernorat(@PathVariable Long id, Gouvernorat gouvernorat) {
		getGouvernorat(id);
		// tempsReel.setId(id);
		return gouvernoratRepository.save(gouvernorat);
	}

	@Override
	public void deleteGouvernorat(Long id) {
		 Gouvernorat gouvernorat  = getGouvernorat(id);
		// tempsReel.setId(id);
		 gouvernoratRepository.save(gouvernorat);
		
	}

}
