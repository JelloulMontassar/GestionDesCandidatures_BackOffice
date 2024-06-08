package com.symatique.SmartSoft.DTO;

import com.symatique.SmartSoft.models.Calendrier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalendrierDTO implements Serializable {

    private Long id;
    private String libelle;
    private Date dateDebut;
    private Date dateFin;
    private CandidatDTO candidat;



}
