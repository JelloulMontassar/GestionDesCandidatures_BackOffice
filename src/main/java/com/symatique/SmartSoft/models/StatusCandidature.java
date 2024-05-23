package com.symatique.SmartSoft.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

 
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_StatusCandidature")
@Entity
public class StatusCandidature implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
    @Column(name = "SCa_id")
    private Long id;

    @Column(name = "SCa_titre")
    private String Titre;
    
    @Column(name = "SCa_Libelle")
    private String libelle;
    
    @Column(name = "Ent_Id")
    private Long idEntreprise;
	
	@Column(name = "Ent_Libelle")
	private String libelleEntreprise;
	
	
    
    public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Column(name = "SCa_description")
    private String Description;
    
	@Column(name = "SCa_Supprimer")
	private boolean supression;
    
    public static final String EN_ATTENTE = "En attente";
    public static final String EN_COURS = "En cours";
    public static final String REJETEE = "Rejetée";
    public static final String ACCEPTEE = "Acceptée";
      
    @OneToMany(mappedBy = "statusCandidature")
    private List<Candidature> candidatures;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String titre) {
		Titre = titre;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<Candidature> getCandidatures() {
		return candidatures;
	}

	public void setCandidatures(List<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

	public static String getEnAttente() {
		return EN_ATTENTE;
	}

	public static String getEnCours() {
		return EN_COURS;
	}

	public static String getRejetee() {
		return REJETEE;
	}

	public static String getAcceptee() {
		return ACCEPTEE;
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