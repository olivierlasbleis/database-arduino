package com.ol.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ol.entities.Capteur;
import com.ol.entities.postbody.CapteurPost;
import com.ol.entities.vues.CapteurVue;
import com.ol.exceptions.UtilisateurNonTrouveException;
import com.ol.services.CapteurService;

@RestController
@RequestMapping("/capteur")
public class CapteurController {

	@Autowired
	CapteurService capteurService;
	/**
	 * Méthode qui enregistre en base de donnée le capteur créé dans le font
	 * 
	 * @param capteurPost
	 *            
	 * @return un CapteurVue
	 * @throws UtilisateurNonTrouveException 
	 */
	@PostMapping("/add-capteur")
	public List<CapteurVue> addCapteur(@RequestBody CapteurPost capteurPost) throws UtilisateurNonTrouveException {
		Capteur capteur = capteurService.convertFromCapteurPostToCapteur(capteurPost);
		capteur = capteurService.save(capteur);
		return getAllCapteur();
	}
	
	@GetMapping("/get-all")
	public List<CapteurVue> getAllCapteur() throws UtilisateurNonTrouveException {
		List<Capteur> listeCapteurs = capteurService.getAll();
		return listeCapteurs.stream().map(capteur -> capteurService.convertFromCapteurToCapteurVue(capteur)).collect(Collectors.toList());
	}
	
}
