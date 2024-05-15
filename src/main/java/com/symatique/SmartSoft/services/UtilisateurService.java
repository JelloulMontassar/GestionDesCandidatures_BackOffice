package com.symatique.SmartSoft.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.symatique.SmartSoft.models.Utilisateur;

@Service
public interface UtilisateurService {

	Utilisateur getUtilisateur(Long id);

	List<Utilisateur> getAllUtilisateurs();

	Utilisateur saveUtilisateur(Utilisateur utilisateur);

	Utilisateur updateUtilisateur(Utilisateur utilisateur);

	void deleteUtilisateur(Long id);

	boolean checkEmailExists(String email, Long id);

	boolean checkEmail(String email);
	
	boolean verifierProfile(Long id);
	
	boolean verifierPoste(Long id);
	
    List<Utilisateur> findUsersByAttributes(Long profileId, Long posteId, String email, String statut);

}
