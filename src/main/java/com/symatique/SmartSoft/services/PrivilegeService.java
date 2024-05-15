package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Privilege;

@Service
public interface PrivilegeService {

	Privilege getPrivilege(Long id);

	List<Privilege> getAllPrivileges();

	Privilege savePrivilege(Privilege privileges);

	Privilege updatePrivilege(Privilege privileges);

	void deletePrivilege(Long id);

	boolean checkLibelleExists(String libelle, Long id);

	boolean checkLibelle(String libelle);

	List<Privilege> saveAll(List<Privilege> listePrivilege);

	List<Privilege> searchByLibelleAndIdEntreprise(String libelle, Long entrepriseId);

	List<Privilege> searchByModuleAndIdEntreprise(String libelle, Long entrepriseId);

}
