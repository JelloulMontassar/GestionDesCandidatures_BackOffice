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
@Table(name = "T_Gouvernorat")
public class Gouvernorat implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Gov_Id")
    private Long id;

    @Column(name = "Gov_Libelle")
    private String libelle;

    @Column(name = "Gov_Description")
    private String description;

    @Column(name = "Gov_DateSynch")
    private long dateSynch;
    
    @Column(name="Gov_Latitude")
    private String latitude;
    
    @Column(name="Gov_Longitude")
    private String longitude;
    
    
    @OneToMany(mappedBy = "gouvernorat", fetch = FetchType.LAZY)
    private List<Delegation> listDelegations;


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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public long getDateSynch() {
		return dateSynch;
	}


	public void setDateSynch(long dateSynch) {
		this.dateSynch = dateSynch;
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


	public List<Delegation> getListDelegations() {
		return listDelegations;
	}


	public void setListDelegations(List<Delegation> listDelegations) {
		this.listDelegations = listDelegations;
	}
    
    
    
}
