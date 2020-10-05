package com.ol.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ol.entities.Capteur;
import com.ol.entities.Mesure;
import com.ol.entities.Utilisateur;
import com.ol.entities.postbody.MesurePost;
import com.ol.entities.postbody.UtilisateurCreationComptePost;
import com.ol.entities.vues.MesureVue;
import com.ol.entities.vues.UtilisateurVue;
import com.ol.exceptions.CapteurNonTrouveException;
import com.ol.exceptions.MesuresNonTrouveException;
import com.ol.services.CapteurService;
import com.ol.services.MesureService;

@RestController
@RequestMapping("mesure")
public class MesureController {

	@Autowired
	MesureService mesureService;
	@Autowired
	CapteurService capteurService;
	
	@GetMapping("/{apiKeyCapteur}")
	public List<MesureVue> getListMesureFromCapteur(@PathVariable(value="apiKeyCapteur") String apiKeyCapteur) 
			throws MesuresNonTrouveException, CapteurNonTrouveException{
		Capteur capteur = capteurService.findByApiKey(apiKeyCapteur);
		return mesureService.findByCapteur(capteur).stream().map(m -> mesureService.convertFromMesureToMesureVue(m)).collect(Collectors.toList());
		
	}
	@PostMapping("/add-mesure/{apiKeyCapteur}")
	public MesureVue creerCompte(@PathVariable(value="apiKeyCapteur") String apiKeyCapteur, 
			@RequestBody MesurePost mesurePost) 
					throws CapteurNonTrouveException {
		Capteur capteur = capteurService.findByApiKey(apiKeyCapteur);
		Mesure mesure = mesureService.convertFromMesurePostToMesure(mesurePost);
		mesure.setCapteur(capteur);
		mesure = mesureService.save(mesure);
		return mesureService.convertFromMesureToMesureVue(mesure);

	}
}
