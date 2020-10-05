package com.ol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ol.entities.Capteur;
import com.ol.entities.Mesure;
import com.ol.entities.postbody.MesurePost;
import com.ol.entities.vues.MesureVue;
import com.ol.exceptions.CapteurNonTrouveException;
import com.ol.exceptions.MesuresNonTrouveException;
import com.ol.repositories.MesureRepository;

@Service
public class MesureService {

	@Autowired
	CapteurService capteurService;
	@Autowired
	MesureRepository mesureRepository;
	
	public List<Mesure> getListeMesure(String apiKeyCapteur) throws CapteurNonTrouveException, MesuresNonTrouveException{
		Capteur capteur = capteurService.findByApiKey(apiKeyCapteur);
		return mesureRepository.findByCapteur(capteur).orElseThrow(MesuresNonTrouveException::new);
		
	}

	public Mesure convertFromMesurePostToMesure(MesurePost mesurepost) {
		
		return new Mesure(mesurepost.getValeur(),mesurepost.getDate());
	}

	public Mesure save(Mesure mesure) {
		return mesureRepository.save(mesure);
	}

	public MesureVue convertFromMesureToMesureVue(Mesure mesure) {
		
		return new MesureVue(mesure.getValeur(),mesure.getDate());
	}

	public List<Mesure> findByCapteur(Capteur capteur) throws MesuresNonTrouveException {
	
		return mesureRepository.findByCapteur(capteur).orElseThrow(MesuresNonTrouveException::new);
	}
}
