package com.symatique.SmartSoft.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "T_Domaine")
public class Domaine implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Dom_Id")
	private Long id;

	@Column(name = "Dom_Libelle")
	private String libelle;

	@Column(name = "Dom_Code")
	private String code;

	@Column(name = "Dom_Entite")
	private String entite;

	@Column(name = "Dom_Description")
	private String description;

	@Column(name = "Dom_CodePostal")
	private String codePostal;

	@Column(name = "Dom_Adresse")
	private String adresse;

	@Column(name = "Dom_Telephone")
	private String telephone;

	@Column(name = "Dom_Fax")
	private String fax;

	@Column(name = "Dom_Email")
	private String email;

	@Column(name = "Dom_Latitude")
	private String latitude;

	@Column(name = "Dom_Longitude")
	private String longitude;

	@Column(name = "Dom_MatriculeFiscale")
	private String matriculeFiscale;

	@Column(name = "Dom_RepresentantLegal")
	private String representantLegal;

	@Column(name = "Dom_Capital", scale = 3, precision = 28)
	private BigDecimal capital;

	@Column(name = "Dom_Liee")
	private Boolean liee;

	@Column(name = "Dom_DateSynch")
	private Long dateSynch;

	@Column(name = "Dom_Logo")
	private String logo;

	@Column(name = "Dom_Statut")
	private boolean statut;

	@Column(name = "Dom_SituationJuridique")
	private boolean situationJuridique;

	@Column(name = "Dom_RME")
	private String rme;

	@Column(name = "Dom_ValeurNominale", scale = 3, precision = 28)
	private BigDecimal valeurNominale;

	@Column(name = "Dom_Tribunal")
	private String tribunal;

	@Column(name = "Dom_CodeEnDouane")
	private String codeEnDouane;

	@Column(name = "Dom_Supprimer")
	private boolean supression;

	@ManyToOne
	@JoinColumn(name = "Ent_Id", referencedColumnName = "Ent_Id", nullable = true)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Entreprise entreprise;
	
	



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		if (libelle != null && !libelle.equals("")) {
			libelle = libelle.substring(0, 1).toUpperCase() + "" + libelle.substring(1);
		}
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEntite() {
		return entite;
	}

	public void setEntite(String entite) {
		this.entite = entite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getMatriculeFiscale() {
		return matriculeFiscale;
	}

	public void setMatriculeFiscale(String matriculeFiscale) {
		this.matriculeFiscale = matriculeFiscale;
	}

	public String getRepresentantLegal() {
		return representantLegal;
	}

	public void setRepresentantLegal(String representantLegal) {
		this.representantLegal = representantLegal;
	}

	public BigDecimal getCapital() {
		return capital;
	}

	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}

	public Boolean getLiee() {
		return liee;
	}

	public void setLiee(Boolean liee) {
		this.liee = liee;
	}

	public Long getDateSynch() {
		return dateSynch;
	}

	public void setDateSynch(Long dateSynch) {
		this.dateSynch = dateSynch;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public boolean isSituationJuridique() {
		return situationJuridique;
	}

	public void setSituationJuridique(boolean situationJuridique) {
		this.situationJuridique = situationJuridique;
	}

	public String getRme() {
		return rme;
	}

	public void setRme(String rme) {
		this.rme = rme;
	}

	public BigDecimal getValeurNominale() {
		return valeurNominale;
	}

	public void setValeurNominale(BigDecimal valeurNominale) {
		this.valeurNominale = valeurNominale;
	}

	public String getTribunal() {
		return tribunal;
	}

	public void setTribunal(String tribunal) {
		this.tribunal = tribunal;
	}

	public String getCodeEnDouane() {
		return codeEnDouane;
	}

	public void setCodeEnDouane(String codeEnDouane) {
		this.codeEnDouane = codeEnDouane;
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

	
	
	

}
