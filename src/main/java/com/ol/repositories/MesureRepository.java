package com.ol.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ol.entities.Capteur;
import com.ol.entities.Mesure;

@Repository
public interface MesureRepository extends JpaRepository<Mesure, Integer>{

	@Query("select m from Mesure m where m.capteur=?1")
	Optional<List<Mesure>> findByCapteur(Capteur capteur);

	
}
