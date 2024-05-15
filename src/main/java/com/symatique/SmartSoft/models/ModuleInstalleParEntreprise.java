package com.symatique.SmartSoft.models;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name = "T_ModuleInstalleParEntreprise")
public class ModuleInstalleParEntreprise implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MIEn_Id")
	private Long id;

	@Column(name = "MIEn_Code")
	private int code;

	@Column(name = "MIEn_Libelle")
	private String libelle;
	
	@Column(name = "MIEn_Icon")
	private String icon;

	@Column(name = "MIEn_Active")
	private boolean active;


	@ManyToOne
	@JoinColumn(name = "Ent_Id", referencedColumnName = "Ent_Id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Entreprise entreprise;
	
	
	@OneToMany(mappedBy = "moduleInstalleParEntreprise", cascade = CascadeType.ALL)
	private List<DetailModuleInstalleParEntreprise> listDetailModuleInstalleParEntreprise;


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


	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Entreprise getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}


	public List<DetailModuleInstalleParEntreprise> getListDetailModuleInstalleParEntreprise() {
		return listDetailModuleInstalleParEntreprise.stream()
	            .sorted(Comparator.comparing(DetailModuleInstalleParEntreprise::getCode))
	            .collect(Collectors.toList());
	}


	public void setListDetailModuleInstalleParEntreprise(List<DetailModuleInstalleParEntreprise> listDetailModuleInstalleParEntreprise) {
		
		this.listDetailModuleInstalleParEntreprise = listDetailModuleInstalleParEntreprise;
	}

	
	

}
