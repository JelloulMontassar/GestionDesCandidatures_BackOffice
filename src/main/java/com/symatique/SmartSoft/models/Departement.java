package com.symatique.SmartSoft.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_Departement")
public class Departement implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Dep_Id")
	private Long id;

	@Column(name = "Dep_Libelle")
	private String libelle;

	@Column(name = "Dep_Description")
	private String description;

	@Column(name = "Dep_Supprimer")
	private boolean supression;

	
	@OneToMany(mappedBy = "departement", fetch = FetchType.LAZY)
	private List<Poste> ListPostes;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isSupression() {
		return supression;
	}

	public void setSupression(boolean supression) {
		this.supression = supression;
	}

	public List<Poste> getListPostes() {
		return ListPostes;
	}

	public void setListPostes(List<Poste> listPostes) {
		ListPostes = listPostes;
	}

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
	
	

}
