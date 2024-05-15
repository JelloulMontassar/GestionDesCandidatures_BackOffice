package com.symatique.SmartSoft.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Delegation;
import com.symatique.SmartSoft.repository.DelegationRepository;
import com.symatique.SmartSoft.services.DelegationService;

@Service
public class DelegationServiceImpl implements DelegationService {

	@Autowired
	private DelegationRepository delegationRepository;

	@Override
	public Delegation getDelegation(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return delegationRepository.findById(id).get();
	}

	@Override
	public List<Delegation> getAllDelegations() {
		// TODO Auto-generated method stub
		return delegationRepository.findAll();
	}

	@Override
	public Delegation saveDelegation(Delegation delegation) {
		// TODO Auto-generated method stub
		return delegationRepository.save(delegation);
	}

	@Override
	public Delegation updateDelegation(@PathVariable Long id, Delegation delegation) {
		getDelegation(id);
		// tempsReel.setId(id);
		return delegationRepository.save(delegation);
	}

	@Override
	public void deleteDelegation(Long id) {
		Delegation delegation = getDelegation(id);
		// tempsReel.setId(id);
		delegationRepository.save(delegation);

	}

}
