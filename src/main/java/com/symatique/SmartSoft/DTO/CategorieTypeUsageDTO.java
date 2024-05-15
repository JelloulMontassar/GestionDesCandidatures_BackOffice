package com.symatique.SmartSoft.DTO;

import java.util.List;

import com.symatique.SmartSoft.models.TypeUsager;

import lombok.Data;

@Data
public class CategorieTypeUsageDTO {
	
     private Long id;
	 
	 private  String libelle ;
	 
	 private  String description ;
	 
	 private boolean supression ;
	 
	 private Long idEntreprise;

	 private String libelleEntreprise;
	 
	 private List<TypeUsager> ListTypeUsager;	

}
