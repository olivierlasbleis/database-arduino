package com.ol.services;

import java.util.Arrays;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ol.entities.Role;
import com.ol.entities.Utilisateur;
import com.ol.entities.postbody.UtilisateurCreationComptePost;
import com.ol.entities.vues.UtilisateurVue;
import com.ol.exceptions.UtilisateurNonTrouveException;
import com.ol.repositories.UtilisateurRepository;
import com.ol.utils.UtilisateurConnecteUtils;


@Service
public class UtilisateurService {

	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Utilisateur convertUtilisateurCreationComptePostToUtilisateur(
			UtilisateurCreationComptePost utilisateurCreationComptePost) {
		// TODO Auto-generated method stub
		
		return new Utilisateur(
				utilisateurCreationComptePost.getIdentifiant(),
				passwordEncoder.encode(utilisateurCreationComptePost.getMotDePasse()),
				utilisateurCreationComptePost.getNom(),
				utilisateurCreationComptePost.getPrenom(),
				utilisateurCreationComptePost.getAdresseMail(),
				Arrays.asList(new Role("ROLE_USER")));
		
	}

	public UtilisateurVue convertUtilisateurToUtilisateurVue(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return new UtilisateurVue(utilisateur.getIdentifiant(),
				utilisateur.getNom(),
				utilisateur.getPrenom(),
				utilisateur.getAdresseMail());
	}

	public Utilisateur insererEnBase(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return utilisateurRepository.save(utilisateur);
	}

	public Utilisateur recupererUtilisateur() throws UtilisateurNonTrouveException {
		return utilisateurRepository.findByIdentifiant(UtilisateurConnecteUtils.recupererIdentifiant())
				.orElseThrow(UtilisateurNonTrouveException::new);
	}

	public Utilisateur determinerUtilisateur() throws UtilisateurNonTrouveException {
		Utilisateur utilisateur = utilisateurRepository.findByIdentifiant(UtilisateurConnecteUtils.recupererIdentifiant()).orElseThrow(UtilisateurNonTrouveException::new);
		
		return utilisateur;
	}

}
