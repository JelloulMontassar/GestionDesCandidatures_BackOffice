package com.symatique.SmartSoft.DTO;

import java.util.Date;

import com.symatique.SmartSoft.models.CategorieArticle;

import lombok.Data;

@Data
public class ArticleDTO {

	private Long id;

	private String libelle;

	private String description;

	private Long reference;

	private boolean supression;

	private Long idEntreprise;

	private String libelleEntreprise;

	private Date dateCreation;

	private Long dateSynch;

	private CategorieArticleDTO categorieArticle;

}
