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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "T_CategorieArticle")
@Entity
public class CategorieArticle implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CAr_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "CAr_Libelle")
	private String libelle;

	@Column(name = "CAr_Description")
	private String description;
	
	@Column(name = "CAr_Supprimer")
	private boolean supression ;
	
	@Column(name = "Ent_Id")
    private Long idEntreprise;
	
	@Column(name = "Ent_Libelle")
	private String libelleEntreprise;
	
	@OneToMany(mappedBy = "categorieArticle", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Article> ListArticle;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	


	public List<Article> getListArticle() {
		return ListArticle;
	}


	public void setListArticle(List<Article> listArticle) {
		ListArticle = listArticle;
	}


	public Long getIdEntreprise() {
		return idEntreprise;
	}


	public void setIdEntreprise(Long idEntreprise) {
		this.idEntreprise = idEntreprise;
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
	
	

}
