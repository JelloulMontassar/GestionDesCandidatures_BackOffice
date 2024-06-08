package com.symatique.SmartSoft.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_Candidat")
@Entity
public class Candidat implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cnd_id")
    private Long id;
	
	@Column(name = "Cnd_Libelle")
    private String libelle;

	@Column(name = "Cnd_nom")
    private String nom;

    @Column(name = "Cnd_prenom")
    private String prenom;
    
    @Column(name = "Ent_id")
    private String idEntreprise;
    
    @Column(name = "Ent_libelle")
    private String libelleEntreprise;

    @Column(name = "Cnd_dateNaissance")
    private Date dateNaissance;
    
    @Column(name = "Cnd_DateCreation")
    private Date dateCreation;

    @Column(name = "Cnd_email")
    private String email;
    
    @Column(name = "Cnd_Cin")
    private String cin;

    @Column(name = "Cnd_Gsm")
    private String gsm;
    
    @Column(name = "Cnd_Adresse")
    private String adresse;
    
    @Column(name = "Cnd_Photo")
    private String photo;
    
    @Column(name = "Cnd_Supprimer")
	private boolean supression;
    
    @Column(name = "Gov_Id")
    private Long idGouvernorat;
    
    @Column(name = "Gov_Libelle")
    private String libelleGouvernorat;

    @Column(name = "Gov_LibelleTemp")
    private String libelleGouvernoratTemp;
    @JsonIgnore
    @OneToMany(mappedBy = "candidat")
    private List<Candidature> candidatures;
    
    @OneToMany(mappedBy = "candidat")
    private List<Entretien> entretiens ;
	@OneToOne(fetch = FetchType.LAZY)
	private Utilisateur utilisateur;
	@Column(name = "Can_CV_Path")
	private String cvPath;

	public String getCvPath() {
		return cvPath;
	}

	public void setCvPath(String cvPath) {
		this.cvPath = cvPath;
	}

	public List<Entretien> getEntretiens() {
		return entretiens;
	}

	public void setEntretiens(List<Entretien> entretiens) {
		this.entretiens = entretiens;
	}

	
	public String getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(String idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public String getLibelleEntreprise() {
		return libelleEntreprise;
	}

	public void setLibelleEntreprise(String libelleEntreprise) {
		this.libelleEntreprise = libelleEntreprise;
	}

	public Long getId() {
		return id;
	}
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getGsm() {
		return gsm;
	}
	
	

	public Long getIdGouvernorat() {
		return idGouvernorat;
	}

	public void setIdGouvernorat(Long idGouvernorat) {
		this.idGouvernorat = idGouvernorat;
	}

	public String getLibelleGouvernorat() {
		return libelleGouvernorat;
	}

	public void setLibelleGouvernorat(String libelleGouvernorat) {
		this.libelleGouvernorat = libelleGouvernorat;
	}

	public String getLibelleGouvernoratTemp() {
		return libelleGouvernoratTemp;
	}

	public void setLibelleGouvernoratTemp(String libelleGouvernoratTemp) {
		this.libelleGouvernoratTemp = libelleGouvernoratTemp;
	}

	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	

	public boolean isSupression() {
		return supression;
	}

	public void setSupression(boolean supression) {
		this.supression = supression;
	}

	public List<Candidature> getCandidatures() {
		return candidatures;
	}

	public void setCandidatures(List<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
