package com.symatique.SmartSoft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.symatique.SmartSoft.models.Offre;


@Repository
public interface OffreRepository extends JpaRepository<Offre, Long>  {

	Optional<Offre> findByLibelleAndSupressionAndIdNotAndIdEntreprise(String libelle,boolean supression ,  Long id,Long idEntreprise);

	Optional<Offre> findByLibelleAndSupressionAndIdEntreprise(String libelle,boolean supression, Long idEntreprise);
	@Query("SELECT o FROM Offre o WHERE " +
			"(:libelle IS NULL OR o.libelle LIKE %:libelle%) AND " +
			"(:localisation IS NULL OR o.localisation LIKE %:localisation%) AND " +
			"(:description IS NULL OR o.description LIKE %:description%)")
	List<Offre> searchOffres(String libelle, String localisation, String description);

}
