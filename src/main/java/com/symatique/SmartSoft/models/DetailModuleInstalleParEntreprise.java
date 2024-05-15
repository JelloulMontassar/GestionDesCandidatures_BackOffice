package com.symatique.SmartSoft.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "T_DetailModuleInstalleParEntreprise")
public class DetailModuleInstalleParEntreprise implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DMIEn_Id")
	private Long id;

	@Column(name = "DMIEn_Code")
	private int code;

	@Column(name = "DMIEn_Libelle")
	private String libelle;

	@Column(name = "DMIEn_Lecture")
	private boolean lecture;

	@Column(name = "DMIEn_Creation")
	private boolean creation;

	@Column(name = "DMIEn_Modification")
	private boolean modification;

	@Column(name = "DMIEn_Supression")
	private boolean supression;

	@Column(name = "DMIEn_Activation")
	private boolean activation;
	
	@Column(name = "DMIEn_Active")
	private boolean active;
	
	@Column(name = "Ent_Id")
	private Long idEntreprise;

	
	/*@Column(name = "MIEn_Order")
	private int orderModule;
	*/
	@ManyToOne
	@JoinColumn(name = "MIEn_Id", referencedColumnName = "MIEn_Id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private ModuleInstalleParEntreprise moduleInstalleParEntreprise;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
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



	public ModuleInstalleParEntreprise getModuleInstalleParEntreprise() {
		return moduleInstalleParEntreprise;
	}

	public void setModuleInstalleParEntreprise(ModuleInstalleParEntreprise moduleInstalleParEntreprise) {
		this.moduleInstalleParEntreprise = moduleInstalleParEntreprise;
	}

	public boolean isActivation() {
		return activation;
	}

	public void setActivation(boolean activation) {
		this.activation = activation;
	}

	public boolean isLecture() {
		return lecture;
	}

	public void setLecture(boolean lecture) {
		this.lecture = lecture;
	}

	public boolean isCreation() {
		return creation;
	}

	public void setCreation(boolean creation) {
		this.creation = creation;
	}

	public boolean isModification() {
		return modification;
	}

	public void setModification(boolean modification) {
		this.modification = modification;
	}

	public boolean isSupression() {
		return supression;
	}

	public void setSupression(boolean supression) {
		this.supression = supression;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(Long idEntreprise) {
		this.idEntreprise = idEntreprise;
	}


	
	
	

}
