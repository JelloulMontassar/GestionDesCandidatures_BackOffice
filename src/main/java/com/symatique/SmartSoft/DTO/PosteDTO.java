package com.symatique.SmartSoft.DTO;

import java.util.List;

import com.symatique.SmartSoft.models.Departement;
import com.symatique.SmartSoft.models.Utilisateur;

import lombok.Data;

@Data
public class PosteDTO {

	private Long id;

	private String libelle;

	private String description;

	private boolean supression;
	
	private List<Utilisateur> ListUtilisateurs;

	private Departement departement;
	
	private Long idEntreprise;

	private String libelleEntreprise;

}
