package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Gouvernorat;

@Service
public interface GouvernoratService {

	Gouvernorat getGouvernorat(Long id);

	List<Gouvernorat> getAllGouvernorats();

	Gouvernorat saveGouvernorat(Gouvernorat gouvernorat);

	Gouvernorat updateGouvernorat(Long id, Gouvernorat gouvernorat);

	void deleteGouvernorat(Long id);
}
