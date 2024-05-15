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

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_Privilege")
/*
 * @JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class,
 * property = "id")
 */
public class Privilege implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "Pri_Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "Pri_Libelle")
	private String libelle;
	@Column(name = "Pri_Lecture")
	private boolean lecture;
	@Column(name = "Pri_Creation")
	private boolean creation;
	@Column(name = "Pri_Modification")
	private boolean modification;
	@Column(name = "Pri_Supprimer")
	private boolean supression;

	@Column(name = "Pri_Reinitialisation")
	private boolean reinitialisation;
	@Column(name = "Pri_Synchronisation")
	private boolean synchronisation;
	@Column(name = "Pri_Order")
	private int order;

    @Column(name = "Pri_Module")
    private String module;
    
	@Column(name = "Pri_Active")
	private boolean active;

	@Column(name = "Ent_Id")
	private Long idEntreprise;
	
	@ManyToOne()
	@JoinColumn(name = "Pro_Id", referencedColumnName = "Pro_Id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Profile profile;

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


	public boolean isReinitialisation() {
		return reinitialisation;
	}

	public void setReinitialisation(boolean reinitialisation) {
		this.reinitialisation = reinitialisation;
	}

	public boolean isSynchronisation() {
		return synchronisation;
	}

	public void setSynchronisation(boolean synchronisation) {
		this.synchronisation = synchronisation;
	}


	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}


	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
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
