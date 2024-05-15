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

@Table(name = "T_CategorieTypeUsage")
@Entity
public class CategorieTypeUsage implements Serializable {
	
	 private static final long serialVersionUID = 1L;

	 @Id
	 @Column(name = "CTg_Id")
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 
	 @Column(name ="Ctg_Libelle")
	 private  String libelle ;
	 
	 @Column(name ="Ctg_Description")
	 private  String description ;
	 
	 @Column(name = "CTg_Supprimer")
	 private boolean supression ;
	 
	 @Column(name = "Ent_Id")
	 private Long idEntreprise;

	 @Column(name = "Ent_Libelle")
	 private String libelleEntreprise;
	 
	 @OneToMany(mappedBy = "categorieTypeUsage",fetch = FetchType.LAZY)
		private List<TypeUsager> ListTypeUsager;


		public Long getId() {
			return id;
		}




		public void setId(Long id) {
			this.id = id;
		}
		 



	public List<TypeUsager> getListTypeUsager() {
		return ListTypeUsager;
	}




	public void setListTypeUsager(List<TypeUsager> listTypeUsager) {
		ListTypeUsager = listTypeUsager;
	}




	public String getLibelle() {
		return libelle;
	}




	public void setLibelle(String libelle) {
		this.libelle = libelle;
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




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




}
