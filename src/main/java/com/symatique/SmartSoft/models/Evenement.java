package com.symatique.SmartSoft.models;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "T_Evenement")
@Entity
public class Evenement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Evn_id")
    private Long id;

    @Column(name = "Evn_titre")
    private String titre;

    @Column(name = "Evn_description", length = 1000)
    private String description;

    @Column(name = "Evn_date_debut")
    private Date dateDebut;

    @Column(name = "Evn_date_fin")
    private Date dateFin;
    
    @Column(name = "Env_Libelle")
    private String libelle;
    
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Calendrier getCalendrier() {
		return calendrier;
	}

	public void setCalendrier(Calendrier calendrier) {
		this.calendrier = calendrier;
	}

	@Column(name = "Evn_Supprimer")
	private boolean supression;
    
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "Ent_Id") private Entreprise entreprise;
	 */

    @Column(name = "Ent_Id")
    private Long idEntreprise;
	
	@Column(name = "Ent_Libelle")
	private String libelleEntreprise;
	
    @ManyToOne
    @JoinColumn(name = "Rec_Id")
    private Recrutement recrutement;
    
    
    @ManyToOne
    @JoinColumn(name = "Cal_Id")
    private Calendrier calendrier ;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	/*
	 * public Entreprise getEntreprise() { return entreprise; }
	 * 
	 * public void setEntreprise(Entreprise entreprise) { this.entreprise =
	 * entreprise; }
	 */

	public Recrutement getRecrutement() {
		return recrutement;
	}

	public void setRecrutement(Recrutement recrutement) {
		this.recrutement = recrutement;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public boolean isSupression() {
		return supression;
	}

	public void setSupression(boolean supression) {
		this.supression = supression;
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