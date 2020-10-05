package com.ol.entities.postbody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurCreationComptePost {

	private String identifiant;
	private String motDePasse;
	private String nom;
	private String prenom;
	private String adresseMail;
	
	public UtilisateurCreationComptePost(String motDePasse, String nom, String prenom, String adresseMail) {
		super();
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
	}
}
