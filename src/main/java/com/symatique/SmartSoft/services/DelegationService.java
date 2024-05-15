package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Delegation;

@Service
public interface DelegationService {

	Delegation getDelegation(Long id);

	List<Delegation> getAllDelegations();

	Delegation saveDelegation(Delegation delegation);

	Delegation updateDelegation(Long id, Delegation delegation);

	void deleteDelegation(Long id);
}
