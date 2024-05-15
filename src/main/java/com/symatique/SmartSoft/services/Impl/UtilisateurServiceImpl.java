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
import com.symatique.SmartSoft.services.EmailService;
import com.symatique.SmartSoft.services.UtilisateurService;


@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
    private EmailService emailService;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

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
		 String randomPassword = generateRandomPassword();
	        
	        String hashedPassword = passwordEncoder.encode(randomPassword);
	        
	        utilisateur.setPasswd(hashedPassword);
	        

	     // Obtention de l'adresse e-mail de l'utilisateur
	        String to = utilisateur.getEmail();

	        // Construction du sujet du courrier électronique
	        String subject = "Bienvenue dans notre application";

	        String message = String.format("Mr %s %s, soyez le bienvenu parmi nous.%n%n" +
	                "Votre compte est comme suit:%n%n" +
	                "\tIdentifiant: %s%n" +
	                "\tMot de passe: %s%n" +
	                "\tEntreprise: %s%n%n" +
	                "Pour plus d'informations, veuillez contacter votre administrateur sur l'adresse suivante: %s",
	                utilisateur.getPrenom(), utilisateur.getNom(), utilisateur.getEmail(),
	                randomPassword, utilisateur.getLibelleEntrepriseEnCours(), "admin@symatique.com http://102.164.112.102:8080/sw/");
	        try {
	            emailService.sendEmail(to, subject, message);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
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

	 @Override
	 public String generateRandomPassword() {
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        StringBuilder randomPassword = new StringBuilder();
	        for (int i = 0; i < 10; i++) {
	            int index = (int) (Math.random() * characters.length());
	            randomPassword.append(characters.charAt(index));
	        }
	        return randomPassword.toString();
	    }
}
