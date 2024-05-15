package com.symatique.SmartSoft.DTO;



import com.symatique.SmartSoft.models.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

	private String token;
	private Utilisateur utilisateur;
	

	

}
