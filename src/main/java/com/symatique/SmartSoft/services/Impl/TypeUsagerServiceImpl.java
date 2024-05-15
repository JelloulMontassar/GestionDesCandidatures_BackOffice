package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.CategorieTypeUsage;
import com.symatique.SmartSoft.models.TypeUsager;
import com.symatique.SmartSoft.repository.TypeUsagerRepository;
import com.symatique.SmartSoft.services.TypeUsagerService;

@Service
public class TypeUsagerServiceImpl implements TypeUsagerService {

    @Autowired
    private TypeUsagerRepository typeUsagerRepository;
    
   


    @Override
	public TypeUsager getTypeUsager(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return typeUsagerRepository.findById(id).get();
	}

	@Override
	public List<TypeUsager> getAllTypeUsagers() {
		// TODO Auto-generated method stub
		return typeUsagerRepository.findAll().stream().filter(TypeUsager -> TypeUsager.isSupression() == false).collect(Collectors.toList());		
	}

	@Override
	public TypeUsager saveTypeUsager(TypeUsager typeUsager) {
		// TODO Auto-generated method stub
		return typeUsagerRepository.save(typeUsager);
	}

	@Override
	public TypeUsager updateTypeUsager( TypeUsager TypeUsager) {
		return typeUsagerRepository.save(TypeUsager);
	}

	@Override
	public void deleteTypeUsager(Long id) {
		TypeUsager typeUsager = getTypeUsager(id);
		typeUsager.setSupression(true);
		typeUsagerRepository.save(typeUsager);

	}
	
	
	/*@Override
    public TypeUsager getTypeUsagerByCycleParam(CycleParam cycleParam) {
        return typeUsagerRepository.findByCycleParam(cycleParam);
    }*/
	
	@Override
	public boolean checkLibelle(String libelle, Long idEntreprise) {
		
		Optional<TypeUsager> existingTypeUsager = typeUsagerRepository.findByLibelleAndSupressionAndIdEntreprise(libelle,
				false, idEntreprise);

		return existingTypeUsager.isPresent();
	}

	public boolean checkLibelleExists(String libelle,Long idEntreprise, Long id) {
	    // Recherche la puce avec le même numéro d'appel, en excluant celle avec l'id spécifié
	    Optional<TypeUsager> existingTypeUsager = typeUsagerRepository.findByLibelleAndSupressionAndIdNotAndIdEntreprise(libelle, false, id, idEntreprise);
	    return existingTypeUsager.isPresent();
	  }
	
	
	
}