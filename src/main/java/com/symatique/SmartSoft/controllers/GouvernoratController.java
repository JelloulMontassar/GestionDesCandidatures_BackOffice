package com.symatique.SmartSoft.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.symatique.SmartSoft.models.Gouvernorat;
import com.symatique.SmartSoft.services.GouvernoratService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class GouvernoratController {

	@Autowired
	private GouvernoratService  gouvernoratService ;
	
	@GetMapping("/allGouvernorat")
	public ResponseEntity<List<Gouvernorat>> Listgouvernorat() {
		List<Gouvernorat> gouvernorats = gouvernoratService.getAllGouvernorats();
		return ResponseEntity.status(HttpStatus.OK).body(gouvernorats);
	}
	
	
}
