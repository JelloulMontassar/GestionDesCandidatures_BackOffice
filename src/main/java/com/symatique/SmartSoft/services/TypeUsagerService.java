package com.symatique.SmartSoft.services;

import java.util.List;

import com.symatique.SmartSoft.models.TypeUsager;

public interface TypeUsagerService {

	TypeUsager getTypeUsager(Long id);

	List<TypeUsager> getAllTypeUsagers();

	TypeUsager saveTypeUsager(TypeUsager typeUsager);

	TypeUsager updateTypeUsager(TypeUsager typeUsager);

	void deleteTypeUsager(Long id);
	
	boolean checkLibelle(String libelle, Long idEntreprise);

	boolean checkLibelleExists(String libelle, Long idEntreprise, Long id);

	//TypeUsager getTypeUsagerByCycleParam(CycleParam cycleParam);
	
  

}
