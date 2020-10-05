package com.ol.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ol.entities.Capteur;
import com.ol.entities.TypeCapteur;
import com.ol.entities.Utilisateur;
import com.ol.entities.postbody.CapteurPost;
import com.ol.entities.vues.CapteurVue;
import com.ol.exceptions.CapteurNonTrouveException;
import com.ol.exceptions.UtilisateurNonTrouveException;
import com.ol.repositories.CapteurRepository;


@Service
public class CapteurService {

	@Autowired
	UtilisateurService utilisateurService;
	@Autowired
	CapteurRepository capteurRepository;
	
	public Capteur save(Capteur capteur) {
		return capteurRepository.save(capteur);
	}

	public Capteur convertFromCapteurPostToCapteur(CapteurPost capteurPost) throws UtilisateurNonTrouveException {
		// TODO Auto-generated method stub
		Utilisateur utilisateur = utilisateurService.determinerUtilisateur();
		String apiKey = RandomStringUtils.randomAlphabetic(10);
		return new Capteur (capteurPost.getNomCapteur(),
				apiKey,
				new TypeCapteur(capteurPost.getTypeCapteur()),
				utilisateur
				);
	}

	public List<Capteur> getAll() throws UtilisateurNonTrouveException {
		Utilisateur utilisateur = utilisateurService.determinerUtilisateur();
		List<Capteur> listeCapteur = new ArrayList<>();
		if (capteurRepository.findByUtilisateur(utilisateur).isPresent()) {
			listeCapteur = capteurRepository.findByUtilisateur(utilisateur).get();
		}
		
		return listeCapteur;
	}

	public CapteurVue convertFromCapteurToCapteurVue(Capteur capteur) {
		// TODO Auto-generated method stub
		return new CapteurVue(capteur.getNomCapteur(),
				capteur.getTypeCapteur().getLibelle(),
				capteur.getApiKey());
	}

	public Capteur findByApiKey(String apiKeyCapteur) throws CapteurNonTrouveException {
		
		return capteurRepository.findByApiKey(apiKeyCapteur).orElseThrow(CapteurNonTrouveException::new);
	}

}
