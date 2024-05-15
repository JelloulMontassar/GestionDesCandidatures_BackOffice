package com.symatique.SmartSoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.symatique.SmartSoft.models.CategorieArticle;


@Repository
public interface CategorieArticleRepository extends JpaRepository<CategorieArticle, Long>  {

	Optional<CategorieArticle> findByLibelleAndSupressionAndIdNotAndIdEntreprise(String libelle,boolean supression ,  Long id,Long idEntreprise);

	Optional<CategorieArticle> findByLibelleAndSupressionAndIdEntreprise(String libelle,boolean supression, Long idEntreprise);

}
