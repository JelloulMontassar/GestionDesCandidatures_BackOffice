package com.symatique.SmartSoft.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "T_Emplacement")
public class Emplacement implements Serializable {
	
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Emp_Id")
	private Long id;
	
	@Column(name = "Emp_Libelle")
	private String libelle;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name = "Emp_DateCreation")
	private Date dateCreation;
	
	@Column(name = "Emp_Description")
	private String description;
	
	@Column(name = "Emp_Supprimer")
	private boolean supression;
	
	public Long getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(Long idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public String getLibelleEntreprise() {
		return libelleEntreprise;
	}

	public void setLibelleEntreprise(String libelleEntreprise) {
		this.libelleEntreprise = libelleEntreprise;
	}

	@Column(name = "Ent_Id")
	private Long idEntreprise;

	@Column(name = "Ent_Libelle")
	private String libelleEntreprise;
	
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

	public boolean isSupression() {
		return supression;
	}

	public void setSupression(boolean supression) {
		this.supression = supression;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
