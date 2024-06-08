package com.symatique.SmartSoft.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_Calendrier")
@Entity
public class Calendrier implements Serializable {

	private static final long serialVersionUID = 1L;
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    
	    @Column(name = "Cal_Id")
	    private Long id;

	    @Column(name = "Cal_Libelle")
	    private String libelle;
	    
	    public String getLibelle() {
			return libelle;
		}

		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}

		@Column(name = "Cal_DateDebut")
	    private Date dateDebut;

	    @Column(name = "Cal_DateFin")
	    private Date dateFin;

	    @Column(name = "Cal_Description")
	    private String description;
	    
	    @Column(name = "Cal_Supprimer")
		private boolean supression;
	    @OneToOne
		private Candidat candidat;


	    @Column(name = "Cal__Etat") //0:Modifiable & 1:Non Modifiable (Dimanche)
	    private int etat;

		public Candidat getCandidat() {
			return candidat;
		}

		public void setCandidat(Candidat candidat) {
			this.candidat = candidat;
		}

		public List<Recrutement> getRecrutements() {
			return recrutements;
		}

		public void setRecrutements(List<Recrutement> recrutements) {
			this.recrutements = recrutements;
		}

		@Column(name = "Ent_Id")
	    private Long idEntreprise;
	    
	    @OneToMany(mappedBy = "calendrier")
	    private List<Evenement> evenements = new ArrayList<>();
	  
	    @OneToMany(mappedBy = "calendrier")
	    private List<Recrutement> recrutements = new ArrayList<>();

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		

		public boolean isSupression() {
			return supression;
		}

		public void setSupression(boolean supression) {
			this.supression = supression;
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getEtat() {
			return etat;
		}

		public void setEtat(int etat) {
			this.etat = etat;
		}

		public Long getIdEntreprise() {
			return idEntreprise;
		}

		public void setIdEntreprise(Long idEntreprise) {
			this.idEntreprise = idEntreprise;
		}

		public List<Evenement> getEvenements() {
			return evenements;
		}

		public void setEvenements(List<Evenement> evenements) {
			this.evenements = evenements;
		}

		    


} 
