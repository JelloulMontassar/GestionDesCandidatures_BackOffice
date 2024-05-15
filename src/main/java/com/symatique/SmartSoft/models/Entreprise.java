package com.symatique.SmartSoft.models;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "T_Entreprise")
public class Entreprise implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Ent_Id")
	private Long id;

	@Column(name = "Ent_Logo")
	private String logo;

	@Column(name = "Ent_code")
	private String code;

	@Column(name = "Ent_Libelle")
	private String libelle;

	@Column(name = "Ent_matriculeFiscale")
	private String matriculeFiscale;

	@Column(name = "Ent_RepresentantLegal")
	private String representantLegal;

	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name = "Ent_dateCreation")
	private Date dateCreation;

	@Column(name = "Ent_DateSynchro")
	private Long dateSynchro;

	@Column(name = "Ent_Supprimer")
	private boolean supression;

	@Column(name = "Ent_CodePostal")
	private String codePostal;

	@Column(name = "Ent_Adresse")
	private String adresse;

	@Column(name = "Ent_SiteWeb")
	private String siteWeb;

	@Column(name = "Ent_Email")
	private String email;

	@Column(name = "Pys_CodeTelephonique")
	private String codeTelephonique;

	@Column(name = "Ent_Telephone")
	private String telephone;

	@Column(name = "Ent_Fax")
	private String fax;

	@Column(name = "Ent_Description")
	private String description;
	
	@Column(name = "Ent_ParamBatiment")
	private boolean paramBatiment;

	@OneToMany(mappedBy = "entreprise" )
	private List<ModuleInstalleParEntreprise> listModuleInstalleParEntreprise;

	@OneToMany(mappedBy = "entreprise", fetch = FetchType.LAZY)
	private List<Domaine> listDomaines;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Long getDateSynchro() {
		return dateSynchro;
	}

	public void setDateSynchro(Long dateSynchro) {
		this.dateSynchro = dateSynchro;
	}

	public boolean isSupression() {
		return supression;
	}

	public void setSupression(boolean supression) {
		this.supression = supression;
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

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodeTelephonique() {
		return codeTelephonique;
	}

	public void setCodeTelephonique(String codeTelephonique) {
		this.codeTelephonique = codeTelephonique;
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

	public String getDescription() {
		return description;
	}

	public String getDescriptionString() {
		if (description != null && !description.equals("")) {
			return description;
		}
		return "---";
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ModuleInstalleParEntreprise> getListModuleInstalleParEntreprise() {
		return listModuleInstalleParEntreprise.stream()
	            .sorted(Comparator.comparing(ModuleInstalleParEntreprise::getCode))
	            .collect(Collectors.toList());
	}

	public void setListModuleInstalleParEntreprise(List<ModuleInstalleParEntreprise> listModuleInstalleParEntreprise) {
		this.listModuleInstalleParEntreprise = listModuleInstalleParEntreprise;
	}

	public List<Domaine> getListDomaines() {
		return listDomaines;
	}

	public void setListDomaines(List<Domaine> listDomaines) {
		this.listDomaines = listDomaines;
	}

	public boolean isParamBatiment() {
		return paramBatiment;
	}

	public void setParamBatiment(boolean paramBatiment) {
		this.paramBatiment = paramBatiment;
	}



}
