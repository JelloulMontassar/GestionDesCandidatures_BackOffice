package com.symatique.SmartSoft.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.symatique.SmartSoft.models.Delegation;
import com.symatique.SmartSoft.services.DelegationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DelegationController {

	@Autowired
	private DelegationService delegationService ;
	
	
	@GetMapping("/allDelegation")
	public ResponseEntity<List<Delegation>> ListDelegation() {
		List<Delegation> delegations = delegationService.getAllDelegations();
		return ResponseEntity.status(HttpStatus.OK).body(delegations);
	}
	
}
