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
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

 
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_Article")
@Entity
public class Article implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "Art_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "Art_Libelle")
	private String libelle;

	@Column(name = "Art_Description")
	private String description;
	
	@Column(name = "Art_Reference")
	private Long reference;

	
	@Column(name = "Art_Supprimer")
	private boolean supression ;

	@Column(name = "Ent_Id")
    private Long idEntreprise;
	
	@Column(name = "Ent_Libelle")
	private String libelleEntreprise;
	
	@Column(name = "Art_DateCreation")
	private Date dateCreation;
	
    @Column(name = "Art_DateSynchro")
    private Long dateSynch;
	

	@ManyToOne
	@JoinColumn(name = "CAr_Id", referencedColumnName = "CAr_Id", nullable = true)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private CategorieArticle categorieArticle ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getReference() {
		return reference;
	}

	public void setReference(Long reference) {
		this.reference = reference;
	}

	

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public CategorieArticle getCategorieArticle() {
		return categorieArticle;
	}

	public void setCategorieArticle(CategorieArticle categorieArticle) {
		this.categorieArticle = categorieArticle;
	}

	public Long getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(Long idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public String getLibelle() {
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

	public String getLibelleEntreprise() {
		return libelleEntreprise;
	}

	public void setLibelleEntreprise(String libelleEntreprise) {
		this.libelleEntreprise = libelleEntreprise;
	}

	public Long getDateSynch() {
		return dateSynch;
	}

	public void setDateSynch(Long dateSynch) {
		this.dateSynch = dateSynch;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", libelle=" + libelle + ", description=" + description + ", reference="
				+ reference + ", supression=" + supression + ", idEntreprise=" + idEntreprise + ", libelleEntreprise="
				+ libelleEntreprise + ", dateCreation=" + dateCreation + ", dateSynch=" + dateSynch
				+ ", categorieArticle=" + categorieArticle + "]";
	}



	
	
}
