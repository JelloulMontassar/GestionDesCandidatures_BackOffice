package com.symatique.SmartSoft.services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.symatique.SmartSoft.models.Utilisateur;
import com.symatique.SmartSoft.repository.UtilisateurRepository;
import com.symatique.SmartSoft.services.UtilisateurService;


@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Transactional
	@Override
	public Utilisateur getUtilisateur(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findById(id).get();
	}

	@Transactional
	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		// TODO Auto-generated method stub
		return utilisateurRepository.findAll().stream().filter(utilisateur -> utilisateur.isSupression() == false)
				.collect(Collectors.toList());

	}

	@Transactional
	@Override
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return utilisateurRepository.save(utilisateur);
	}

	@Transactional
	@Override
	public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	@Transactional
	@Override
	public void deleteUtilisateur(Long id) {
		Utilisateur user = getUtilisateur(id);
		user.setSupression(true);
		utilisateurRepository.save(user);

	}

	public boolean checkEmailExists(String email, Long id) {
		Optional<Utilisateur> existingUtilisateur = utilisateurRepository.findByEmailAndIdNot(email, id);
		return existingUtilisateur.isPresent();
	}

	public boolean checkEmail(String email) {
		Optional<Utilisateur> existingUtilisateur = utilisateurRepository.findByEmail(email);
		return existingUtilisateur.isPresent();
	}

	@Override
	public boolean verifierProfile(Long id) {
		return utilisateurRepository.existsByProfileIdAndSupressionFalse(id);
	}

	@Override
	public boolean verifierPoste(Long id) {
		return utilisateurRepository.existsByPosteIdAndSupressionFalse(id);
	}
	
	 @Override
	 public List<Utilisateur> findUsersByAttributes(Long profileId, Long posteId, String email, String statut) {
	        return utilisateurRepository.findUsersByAttributes(profileId, posteId, email, statut);
	    }
	public Utilisateur getUserByEmail(String email) {
		return utilisateurRepository.getUserByEmail(email);
	}

}
