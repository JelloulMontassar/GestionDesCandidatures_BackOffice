package com.symatique.SmartSoft.DTO;

import com.symatique.SmartSoft.models.Candidat;
import com.symatique.SmartSoft.models.Offre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidatureDTO {
    private  Long Id;
    private Offre offre;
    private CandidatDTO candidat;
    private int etat;
}
