package com.symatique.SmartSoft.models;

import java.io.Serializable;
import java.time.LocalDate;


import javax.persistence.*;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "T_Utilisateur", uniqueConstraints = { @UniqueConstraint(columnNames = "Usr_Email"), })
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "Usr_Id")
	private Long id;

	@Column(name = "Usr_Nom")
	private String nom;

	@Column(name = "Usr_Prenom")
	private String prenom;

	@Column(name = "Usr_Statut")
	private String statut;

	@Column(name = "Usr_Langue")
	private String langue;

	@Column(name = "Usr_DateNaissance")
	private LocalDate dateNaissance;

	@Column(name = "Usr_Email", unique = true)
	private String email;

	@Column(name = "Usr_Password")
	private String passwd;
	
	@Column(name = "Usr_Image")
	private String image;
	
	@Column(name = "Usr_Supprimer")
	private boolean supression;
	
	@Column(name = "Usr_IdEntrepriseEnCours")
	private int idEntrepriseEnCours;

	@Column(name = "Usr_LibelleEntrepriseEnCours")
	private String libelleEntrepriseEnCours;
	
	@Column(name = "Usr_Suivre")
	private boolean suivre;

	@Column(name = "Usr_Activer")
	private boolean activer;
	
	@ManyToOne
	@JoinColumn(name = "Pro_Id", referencedColumnName = "Pro_Id", nullable = true)
	private Profile profile;

	@ManyToOne
	@JoinColumn(name = "Pst_Id", referencedColumnName = "Pst_Id", nullable = true)
	private Poste poste;

	@ManyToOne
	@JoinColumn(name = "Ent_Id", referencedColumnName = "Ent_Id", nullable = true)
	private Entreprise entreprise;

	public Utilisateur(String email, String nom, String password) {

		this.email = nom + "@elvage.com";
		this.passwd = password;
		this.nom = nom;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {

		if (nom != null && !nom.equals("")) {
			nom = nom.toUpperCase();
		}
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		if (prenom != null && !prenom.equals("")) {
			prenom = prenom.substring(0, 1).toUpperCase() + "" + prenom.substring(1);
		}
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}




	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public boolean isSupression() {
		return supression;
	}

	public void setSupression(boolean supression) {
		this.supression = supression;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getIdEntrepriseEnCours() {
		return idEntrepriseEnCours;
	}

	public void setIdEntrepriseEnCours(int idEntrepriseEnCours) {
		this.idEntrepriseEnCours = idEntrepriseEnCours;
	}

	public String getLibelleEntrepriseEnCours() {
		return libelleEntrepriseEnCours;
	}

	public void setLibelleEntrepriseEnCours(String libelleEntrepriseEnCours) {
		this.libelleEntrepriseEnCours = libelleEntrepriseEnCours;
	}

	public boolean isSuivre() {
		return suivre;
	}

	public void setSuivre(boolean suivre) {
		this.suivre = suivre;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", statut=" + statut + ", langue="
				+ langue + ", dateNaissance=" + dateNaissance + ", email=" + email + ", passwd=" + passwd + ", image="
				+ image + ", supression=" + supression + ", idEntrepriseEnCours=" + idEntrepriseEnCours
				+ ", libelleEntrepriseEnCours=" + libelleEntrepriseEnCours + ", suivre=" + suivre + ", profile="
				+ profile + ", poste=" + poste + ", entreprise=" + entreprise + "]";
	}

	public boolean isActiver() {
		return activer;
	}

	public void setActiver(boolean activer) {
		this.activer = activer;
	}

	

}
