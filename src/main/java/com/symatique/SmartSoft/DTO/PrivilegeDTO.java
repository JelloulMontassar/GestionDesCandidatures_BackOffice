package com.symatique.SmartSoft.DTO;

import com.symatique.SmartSoft.models.Profile;

import lombok.Data;

@Data
public class PrivilegeDTO {
	
	
	private Long id;

	private String libelle;

	private boolean lecture;

	private boolean creation;

	private boolean modification;

	private boolean supression;

	private boolean reinitialisation;

	private boolean synchronisation;

	private int order;

    private String module;
    
	private boolean active;

	private Long idEntreprise;
	
	private Profile profile;


}
