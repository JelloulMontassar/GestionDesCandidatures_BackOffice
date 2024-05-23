package com.symatique.SmartSoft.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symatique.SmartSoft.models.Article;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	Optional<Article> findByLibelleAndSupressionAndIdEntreprise(String libelle,boolean supression, Long idEntreprise);

	/*@Query(value = "SELECT a FROM Article a WHERE " +
            "(:IdCentre IS NULL OR a.idCentre = :IdCentre) AND " +
            "(:IdBatiment IS NULL OR a.idBatiment = :IdBatiment)")
    List<Article> findArticleByAttributes(
            @Param("IdCentre") Long centreId,
            @Param("IdBatiment") Long batimentId
         
    );*/





}
