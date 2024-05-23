package com.symatique.SmartSoft.models;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_Candidature")
@Entity
public class Candidature implements Serializable {

	private static final long serialVersionUID = 1L;
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "Can_Id", nullable = false)
	    private Long id;
	    
	    @Column(name = "Can_Libelle")
	    private String libelle;

	    public String getLibelle() {
			return libelle;
		}

		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}

		@Column(name = "Can_NomCandidat")
	    private String nomCandidat;

	    @Column(name = "Can_PrenomCandidat")
	    private String prenomCandidat;

	    @Column(name = "Can_Photo")
	    private String photo;

	    @Column(name = "Can_Cin")
	    private String cin;

	    @Column(name = "Can_Gsm")
	    private String gsm;

	    @Column(name = "Can_Email")
	    private String email;

	    @Column(name = "Can_Adresse")
	    private String adresse;

	    @Column(name = "Can_Supprimer")
	    private boolean supression;

	    @Column(name = "Can_DateSynchro")
	    private Long dateSynchro;

	    @Column(name = "Can_DateCreation")
	    private Date dateCreation;



	    // 0: En Attente // 1: Approuve // 2: Rejete
	    @Column(name = "Can_Etat")
	    private int etat;

	    @Column(name = "Can_Description")
	    private String description;

	    @Column(name = "Ent_Id")
	    private Long idEntreprise;

	    @Column(name = "Dom_Id")
	    private Long idDomaine;

	    @Column(name = "Dom_Libelle")
	    private String libelleDomaine;

	    @Column(name = "Dom_Code")
	    private String codeDomaine;
	    
	    @Column(name = "Can_DateValidation")
	    private Date dateValidation;
	        
	    @ManyToOne
	    @JoinColumn(name = "Cnd_id")
	    private Candidat candidat;
	    
	    @ManyToOne
	    @JoinColumn(name = "SCa_id")
	    private StatusCandidature statusCandidature;
	    
	    @ManyToOne
	    @JoinColumn(name = "poste_id")
	    private Poste poste;
	    
	    @ManyToOne
	    @JoinColumn(name = "Rec_Id")
	    private Recrutement recrutement;
	   
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNomCandidat() {
			return nomCandidat;
		}

		public void setNomCandidat(String nomCandidat) {
			this.nomCandidat = nomCandidat;
		}

		public String getPrenomCandidat() {
			return prenomCandidat;
		}

		public void setPrenomCandidat(String prenomCandidat) {
			this.prenomCandidat = prenomCandidat;
		}

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}



		public Long getDateSynchro() {
			return dateSynchro;
		}

		public void setDateSynchro(Long dateSynchro) {
			this.dateSynchro = dateSynchro;
		}

		public Date getDateCreation() {
			return dateCreation;
		}

		public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
		}


		public int getEtat() {
			return etat;
		}

		public void setEtat(int etat) {
			this.etat = etat;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Long getIdEntreprise() {
			return idEntreprise;
		}

		public void setIdEntreprise(Long idEntreprise) {
			this.idEntreprise = idEntreprise;
		}

		public Long getIdDomaine() {
			return idDomaine;
		}

		public void setIdDomaine(Long idDomaine) {
			this.idDomaine = idDomaine;
		}

		public String getLibelleDomaine() {
			return libelleDomaine;
		}

		public void setLibelleDomaine(String libelleDomaine) {
			this.libelleDomaine = libelleDomaine;
		}

		public String getCodeDomaine() {
			return codeDomaine;
		}

		public void setCodeDomaine(String codeDomaine) {
			this.codeDomaine = codeDomaine;
		}


		public Date getDateValidation() {
			return dateValidation;
		}

		public void setDateValidation(Date dateValidation) {
			this.dateValidation = dateValidation;
		}
		

		public boolean isSupression() {
			return supression;
		}

		public void setSupression(boolean supression) {
			this.supression = supression;
		}

		public Candidat getCandidat() {
			return candidat;
		}

		public void setCandidat(Candidat candidat) {
			this.candidat = candidat;
		}

		public StatusCandidature getStatusCandidature() {
			return statusCandidature;
		}

		public void setStatusCandidature(StatusCandidature statusCandidature) {
			this.statusCandidature = statusCandidature;
		}

		public Poste getPoste() {
			return poste;
		}

		public void setPoste(Poste poste) {
			this.poste = poste;
		}

		public Recrutement getRecrutement() {
			return recrutement;
		}

		public void setRecrutement(Recrutement recrutement) {
			this.recrutement = recrutement;
		}


	    

}