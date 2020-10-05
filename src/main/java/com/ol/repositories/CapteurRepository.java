package com.ol.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ol.entities.Capteur;
import com.ol.entities.Utilisateur;

public interface CapteurRepository extends JpaRepository<Capteur, Integer>{

	/**
	 * 
	 * Requete qui récupère une liste de tous les capteurs d'un utilisateur
	 * 
	 * @param utilisateur
	 * 
	 * @return un Optional<List<Capteur>>
	 */
	@Query("select c from Capteur c where c.utilisateur=?1")
	Optional<List<Capteur>> findByUtilisateur(Utilisateur utilisateur);

	/**
	 * 
	 * Requete qui récupère une liste de tous les capteurs d'un utilisateur
	 * 
	 * @param utilisateur
	 * 
	 * @return un Optional<List<Capteur>>
	 */
	@Query("select c from Capteur c where c.apiKey=?1")
	Optional<Capteur> findByApiKey(String apiKeyCapteur);

}
