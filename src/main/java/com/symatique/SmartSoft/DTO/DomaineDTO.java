package com.symatique.SmartSoft.DTO;

import java.math.BigDecimal;
import java.util.List;

import com.symatique.SmartSoft.models.Entreprise;

import lombok.Data;

@Data
public class DomaineDTO {
	
	private Long id;

	private String libelle;

	private String code;

	private String entite;

	private String description;

	private String codePostal;

	private String adresse;

	private Long telephone;

	private String fax;

	private String email;

	private String latitude;

	private String longitude;

	private String matriculeFiscale;

	private String representantLegal;

	private BigDecimal capital;

	private Boolean liee;

	private Long dateSynch;

	private String logo;

	private boolean statut;

	private boolean situationJuridique;

	private String rme;

	private BigDecimal valeurNominale;

	private String tribunal;

	private String codeEnDouane;

	private boolean supression;

	private Entreprise entreprise;
	
	
	

}
