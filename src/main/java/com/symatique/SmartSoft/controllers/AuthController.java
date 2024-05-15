package com.symatique.SmartSoft.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.symatique.SmartSoft.DTO.JwtResponse;
import com.symatique.SmartSoft.DTO.LoginRequest;
import com.symatique.SmartSoft.DTO.MessageResponse;
import com.symatique.SmartSoft.DTO.SignupRequest;
import com.symatique.SmartSoft.config.JwtUtils;

import com.symatique.SmartSoft.models.Utilisateur;

import com.symatique.SmartSoft.repository.UtilisateurRepository;
import com.symatique.SmartSoft.services.UserDetailsImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UtilisateurRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		return ResponseEntity
				.ok(new JwtResponse(jwt,userDetails.getUtilisateur()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {

	

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		Utilisateur user = new Utilisateur( signUpRequest.getEmail(),signUpRequest.getUsername(),
				encoder.encode(signUpRequest.getPassword()));


		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	 @PostMapping("/signout")
	  public ResponseEntity<?> logoutUser() {
	    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
	        .body(new MessageResponse("You've been signed out!"));
	  }
}
