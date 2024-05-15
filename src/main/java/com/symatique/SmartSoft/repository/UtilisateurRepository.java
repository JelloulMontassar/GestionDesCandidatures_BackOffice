package com.symatique.SmartSoft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.symatique.SmartSoft.models.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	Optional<Utilisateur> findByEmail(String email);

	Optional<Utilisateur> findByEmailAndIdNot(String email, Long id);

	Boolean existsByEmail(String email);
	
	boolean existsByProfileIdAndSupressionFalse(Long id);
	
	boolean existsByPosteIdAndSupressionFalse(Long id);
	
	   @Query(value = "SELECT u FROM Utilisateur u WHERE " +
	            "(:profileId IS NULL OR u.profile.id = :profileId) AND " +
	            "(:posteId IS NULL OR u.poste.id = :posteId) AND " +
	            "(COALESCE(:email, '') = '' OR u.email LIKE CONCAT('%', :email, '%')) AND " +
	            "(:statut IS NULL OR u.statut = :statut)")
	    List<Utilisateur> findUsersByAttributes(
	            @Param("profileId") Long profileId,
	            @Param("posteId") Long posteId,
	            @Param("email") String email,
	            @Param("statut") String statut
	    );
}
