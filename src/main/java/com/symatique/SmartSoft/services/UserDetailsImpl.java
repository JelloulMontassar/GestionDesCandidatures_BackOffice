package com.symatique.SmartSoft.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.symatique.SmartSoft.models.Entreprise;

import com.symatique.SmartSoft.models.Profile;
import com.symatique.SmartSoft.models.Utilisateur;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	private Profile profile;

	private Entreprise entreprise;

	private Utilisateur utilisateur;

	public static UserDetailsImpl build(Utilisateur user) {
//z		List<GrantedAuthority> authorities = user.getListProfiles().stream()
//				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
//				.collect(Collectors.toList());

		return new UserDetailsImpl(user.getId(), user.getNom(), user.getEmail(), user.getPasswd(), user.getProfile(),
				user.getEntreprise(), user);
	}

	@Override
	public List<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> listGrantedAuthority = new ArrayList<>();
		// listGrantedAuthority.add(authorities);

		return listGrantedAuthority;
	}

	public Profile getAuthorities(int id) {

		return this.profile;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}