package com.ol.entities.vues;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurVue {
	
	private String identifiant;
	private String nom;
	private String prenom;
	private String adresseMail;

}
