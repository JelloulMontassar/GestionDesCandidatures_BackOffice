package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Privilege;
import com.symatique.SmartSoft.repository.PrivilegeRepository;
import com.symatique.SmartSoft.services.PrivilegeService;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Override
	public Privilege getPrivilege(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return privilegeRepository.findById(id).get();
	}

	@Override
	public List<Privilege> getAllPrivileges() {
		// TODO Auto-generated method stub
	return privilegeRepository.findAll().stream().filter(privilege -> privilege.isSupression() == false).collect(Collectors.toList());		

	}

	@Override
	public Privilege savePrivilege(Privilege privilege) {
		// TODO Auto-generated method stub
		return privilegeRepository.save(privilege);
	}

	@Override
	public Privilege updatePrivilege( Privilege privilege) {
		
		// tempsReel.setId(id);
		return privilegeRepository.save(privilege);
	}

	@Override
	public void deletePrivilege(Long id) {
		Privilege privilege = getPrivilege(id);
		privilege.setSupression(true);
		privilegeRepository.save(privilege);

	}
	
	public boolean checkLibelleExists(String libelle, Long id) {
	    // Recherche la puce avec le même numéro d'appel, en excluant celle avec l'id spécifié
	    Optional<Privilege> existingPrivilege = privilegeRepository.findByLibelleAndSupressionAndIdNot(libelle, false, id);

	    // Si une puce est trouvée, cela signifie que le numéro d'appel existe déjà
	    return existingPrivilege.isPresent();
	  }
	
	
	public boolean checkLibelle(String libelle) {
	    // Recherche la puce avec le même numéro d'appel, en excluant celle avec l'id spécifié
	    Optional<Privilege> existingPrivilege = privilegeRepository.findByLibelleAndSupression(libelle, false);

	    // Si une puce est trouvée, cela signifie que le numéro d'appel existe déjà
	    return existingPrivilege.isPresent();
	  }

	@Override
	public List<Privilege> saveAll(List<Privilege> listePrivilege) {
		// TODO Auto-generated method stub
		return privilegeRepository.saveAll(listePrivilege);
	}
	
	  public List<Privilege> searchByLibelleAndIdEntreprise(String libelle, Long entrepriseId) {
		    // Appel à votre repository pour effectuer la recherche
		    return privilegeRepository.findByLibelleAndIdEntreprise(libelle, entrepriseId);
		  }
	  
	  public List<Privilege> searchByModuleAndIdEntreprise(String libelle, Long entrepriseId) {
		    // Appel à votre repository pour effectuer la recherche
		    return privilegeRepository.findByModuleAndIdEntreprise(libelle, entrepriseId);
		  }
	

}
