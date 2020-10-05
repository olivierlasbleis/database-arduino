package com.ol.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ol.entities.Utilisateur;
import com.ol.entities.postbody.UtilisateurCreationComptePost;
import com.ol.entities.vues.UtilisateurVue;
import com.ol.services.UtilisateurService;


@RestController
@RequestMapping("utilisateur")
public class UtilisateurController {

	@Autowired
	UtilisateurService utilisateurService;
	
	@GetMapping("/without-cookie")
	public String getReponseTestwithout() {
		return "ok without-cookie";
	}
	
	@GetMapping("/with-cookie")
	public String getReponseTestwith() {
		return "ok with-cookie";
	}
	
	/**
	 * Cette methode gère l'url /compte en POST qui permet de créer un
	 * compteUtilisateur en fonction des informations présentes dans le corps de
	 * la requête. Elle transforme d'abord le corps de la requete en objet
	 * Utilisateur. Ensuite elle insère en base cet utilisateur puis renvoi un
	 * objet UtilisateurDTO
	 * 
	 * @param utilisateurCreationComptePost
	 * @return un Dto d’utilisateur
	 */
	@PostMapping("/creation-compte")
	public UtilisateurVue creerCompte( @RequestBody UtilisateurCreationComptePost utilisateurCreationComptePost) {

		Utilisateur utilisateur = utilisateurService
				.convertUtilisateurCreationComptePostToUtilisateur(utilisateurCreationComptePost);
		utilisateur = utilisateurService.insererEnBase(utilisateur);
		return utilisateurService.convertUtilisateurToUtilisateurVue(utilisateur);

	}
}
