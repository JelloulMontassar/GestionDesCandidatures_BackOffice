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
@Table(name = "T_Entretien")
@Entity
public class Entretien implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "Entr_Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Entr_dateEntretien")
    private Date DateEntretien;

    @Column(name = "Entr_type")
    private String Type;       // par exemple : téléphonique, physique, vidéo, etc.

    @Column(name = "Entr_description", length = 1000)
    private String Description;
    
	@Column(name = "Entr_Supprimer")
	private boolean supression;
	
	@Column(name = "Entr_Libelle")
    private String libelle;
    
    

	@ManyToOne
    @JoinColumn(name = "Cnd_id")
    private Candidat candidat;

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


	public boolean isSupression() {
		return supression;
	}
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setSupression(boolean supression) {
		this.supression = supression;
	}

	public Date getDateEntretien() {
		return DateEntretien;
	}

	public void setDateEntretien(Date dateEntretien) {
		DateEntretien = dateEntretien;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
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