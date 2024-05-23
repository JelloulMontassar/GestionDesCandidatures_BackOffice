package com.symatique.SmartSoft.models;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "T_TypeUsager")
@Entity
public class TypeUsager implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	    @Id
	    @Column(name = "TUsa_Id")
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @Column(name = "TUg_Code")
	    private String code;

	    @Column(name = "TUg_Libelle")
	    private String libelle;

	    @Column(name = "TUg_Description")
	    private String description;
	    
	    @Column(name = "TUg_NombreJourCycle")
	    private Long nombreJourCycle;
	    
	    @Column(name = "TUg_PoidsIdeal", scale = 3, precision = 28)
	    private BigDecimal poidsIdeal;
	    
	    @Column(name = "TUg_Photo")
	    private String photo;
	    
	    @Column(name = "TUg_Supprimer")
	    private boolean supression;
	    
	    @Column(name = "TUg_Mixte")
	    private boolean mixte;
	    
	    @Column(name = "TUg_Active")
	    private boolean active;
	    
	    @Column(name = "Ent_Id")
	    private Long idEntreprise;
	    
	    @Column(name = "Ent_Libelle")
		private String libelleEntreprise;
	    
	   /* 
	    @Column(name = "TUg_DateSynch")
	    private Long dateSynch;
       */
	    @ManyToOne
		@JoinColumn(name = "CTg_Id", referencedColumnName = "CTg_Id", nullable = true)
		@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	    private CategorieTypeUsage categorieTypeUsage;

		
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getLibelle() {
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

		public Long getNombreJourCycle() {
			return nombreJourCycle;
		}

		public void setNombreJourCycle(Long nombreJourCycle) {
			this.nombreJourCycle = nombreJourCycle;
		}

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public boolean isSupression() {
			return supression;
		}

		public void setSupression(boolean supression) {
			this.supression = supression;
		}

		public boolean isMixte() {
			return mixte;
		}

		public void setMixte(boolean mixte) {
			this.mixte = mixte;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		public CategorieTypeUsage getCategorieTypeUsage() {
			return categorieTypeUsage;
		}

		public void setCategorieTypeUsage(CategorieTypeUsage categorieTypeUsage) {
			this.categorieTypeUsage = categorieTypeUsage;
		}

		public BigDecimal getPoidsIdeal() {
			return poidsIdeal;
		}

		public void setPoidsIdeal(BigDecimal poidsIdeal) {
			this.poidsIdeal = poidsIdeal;
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
