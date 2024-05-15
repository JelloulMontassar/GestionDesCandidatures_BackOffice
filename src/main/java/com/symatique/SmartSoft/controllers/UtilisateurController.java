package com.symatique.SmartSoft.controllers;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.symatique.SmartSoft.models.Utilisateur;
import com.symatique.SmartSoft.services.UtilisateurService;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.IOException;
import java.io.InputStream;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UtilisateurController {

	private final String DIRECTORY;

	public UtilisateurController(@Value("${DIRECTORY}") String DIRECTORY) {
		super();
		this.DIRECTORY = DIRECTORY;
	}

	@Autowired
	private UtilisateurService utilisateurService;

	@GetMapping("/allUtilisateur")
	public ResponseEntity<List<Utilisateur>> ListUtilisateur(@RequestParam Long id) {
		List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs().stream()
				.filter(e -> e.getIdEntrepriseEnCours() == id && !e.isSupression()).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(utilisateurs);
	}

	@GetMapping("/utilisateur/{idUtilisateur}")
	public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable("idUtilisateur") Long id) {
		Utilisateur utilisateur = utilisateurService.getUtilisateur(id);
		return ResponseEntity.status(HttpStatus.OK).body(utilisateur);
	}

	@PostMapping("/utilisateur")
	public ResponseEntity<Utilisateur> saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		utilisateurService.saveUtilisateur(utilisateur);
		return ResponseEntity.status(HttpStatus.CREATED).body(utilisateur);
	}

	@PostMapping("/saveImage")
	public ResponseEntity<List<String>> saveImage(@RequestParam("files") List<MultipartFile> multipartFiles) {

		List<String> filenames = new ArrayList<>();
		for (MultipartFile file : multipartFiles) {
			String filename = StringUtils.cleanPath(file.getOriginalFilename());
			Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
			try (InputStream inputStream = file.getInputStream()) {
				copy(inputStream, fileStorage, REPLACE_EXISTING);
			} catch (IOException e) {
			}
			try (InputStream inputStream = file.getInputStream()) {
				copy(inputStream, get(DIRECTORY, filename).toAbsolutePath().normalize(),
						REPLACE_EXISTING);
			} catch (IOException e) {
			}
			filenames.add(filename);
			break;
		}
		return ResponseEntity.ok().body(filenames);
	}

	@PutMapping("/utilisateur")
	public Object updateUtilisateur(@RequestBody Utilisateur utilisateur) {
		utilisateur = utilisateurService.updateUtilisateur(utilisateur);
		return ResponseEntity.status(HttpStatus.CREATED).body(utilisateur);
	}

	@DeleteMapping("/utilisateur/{idUtilisateur}")
	public Object deleteUtilisateur(@PathVariable("idUtilisateur") Long id) {
		utilisateurService.deleteUtilisateur(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@GetMapping("/utilisateur/verifierEmailId")
	public ResponseEntity<Boolean> checkLibelleExists(@RequestParam String email, @RequestParam Long id) {
		boolean exist = utilisateurService.checkEmailExists(email, id);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

	@GetMapping("/utilisateur/verifierEmail")
	public ResponseEntity<Boolean> checkLibelle(@RequestParam String email) {

		boolean exist = utilisateurService.checkEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

	@GetMapping("/utilisateur/verifierProfile")
	public ResponseEntity<Boolean> verifierProfile(@RequestParam Long idProfile) {

		boolean exist = utilisateurService.verifierProfile(idProfile);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

	@GetMapping("/utilisateur/verifierPoste")
	public ResponseEntity<Boolean> verifierPoste(@RequestParam Long idPoste) {

		boolean exist = utilisateurService.verifierPoste(idPoste);
		return ResponseEntity.status(HttpStatus.OK).body(exist);
	}

	@GetMapping("/utilisateurs")
	public List<Utilisateur> rechercheUtilisateurs(@RequestParam(required = false) Long profileId,
			@RequestParam(required = false) Long posteId, @RequestParam(required = false) String email,
			@RequestParam(required = false) String statut, @RequestParam(required = false) Long idEntreprise) {
		if (profileId == 0) {
			profileId = null;
		}
		if (posteId == 0) {
			posteId = null;
		}
		if (email.equals("0")) {
			email = null;
		}
		if (statut.equals("0")) {
			statut = null;
		}
		return utilisateurService.findUsersByAttributes(profileId, posteId, email, statut).stream()
				.filter(e -> e.getIdEntrepriseEnCours() == idEntreprise && !e.isSupression())
				.collect(Collectors.toList());
	}

}
