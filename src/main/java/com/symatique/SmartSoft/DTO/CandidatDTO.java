package com.symatique.SmartSoft.DTO;

import java.io.Serializable;
import java.util.Date;

public class CandidatDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String libelle;
    private String nom;
    private String prenom;
    private String idEntreprise;
    private String libelleEntreprise;
    private Date dateNaissance;
    private Date dateCreation;
    private String email;
    private String cin;
    private String gsm;
    private String adresse;
    private String photo;
    private boolean supression;
    private Long idGouvernorat;
    private String libelleGouvernorat;
    private String libelleGouvernoratTemp;
    private String cvPath;
    private Long utilisateurId;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
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

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public String getCvPath() {
        return cvPath;
    }

    public void setCvPath(String cvPath) {
        this.cvPath = cvPath;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }
}
