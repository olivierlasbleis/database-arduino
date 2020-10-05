package com.ol.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.ol.entities.context.UtilisateurConnecte;


@Component
public class UtilisateurConnecteUtils {

	/**
	 * Cette methode permet de récupérer l'identifiant de l'utilisateur connecté
	 * 
	 * @return
	 */
	public static String recupererIdentifiant() {
		return ((UtilisateurConnecte) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getIdentifiant();
	}
}
