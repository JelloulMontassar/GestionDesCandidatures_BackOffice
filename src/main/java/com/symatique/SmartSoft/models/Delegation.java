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


import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_Delegation")
public class Delegation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Del_Id")
    private Long id;

    @Column(name = "Del_Libelle")
    private String libelle;

    @Column(name = "Del_Latitude")
    private String latitude;

    @Column(name = "Del_Longitude")
    private String longitude;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Gov_Id", referencedColumnName = "Gov_Id", nullable = false)
    private Gouvernorat gouvernorat;

    @Column(name = "Del_Description")
    private String description;
    
    @Column(name = "Del_DateSynchro")
    private long dateSynchro;


	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getLibelle() {
		if(libelle != null && !libelle.equals("")) {
			libelle = libelle.substring(0, 1).toUpperCase()+""+libelle.substring(1);
		}
		return libelle;
	}




	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}




	public String getLatitude() {
		return latitude;
	}




	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}




	public String getLongitude() {
		return longitude;
	}




	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}




	public Gouvernorat getGouvernorat() {
		return gouvernorat;
	}




	public void setGouvernorat(Gouvernorat gouvernorat) {
		this.gouvernorat = gouvernorat;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public long getDateSynchro() {
		return dateSynchro;
	}




	public void setDateSynchro(long dateSynchro) {
		this.dateSynchro = dateSynchro;
	}
    
    
    
    
    
}
