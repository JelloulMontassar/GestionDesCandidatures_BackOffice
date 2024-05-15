package com.symatique.SmartSoft.DTO;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class TypeUsagerDTO {
	
    private Long id;
    
    private String code;
    
    private String libelle;
    
    private String description;
    
    private Long nombreJourCycle;
    
    private BigDecimal poidsIdeal;
    
    private String photo;
    
    private boolean supression;
    
    private boolean mixte;
    
    private boolean active;
    
    private Long idEntreprise;
    
    private String libelleEntreprise;

    private CategorieTypeUsageDTO categorieTypeUsage;

}
