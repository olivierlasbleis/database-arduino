package com.ol.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String identifiant;
	private String motDePasse;
	private String nom;
	private String prenom;
	private String adresseMail;
	/**
     * liste des roles de l’utilisateur
     */
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Role> roles;
	public Utilisateur(String identifiant, String motDePasse, String nom, String prenom, String adresseMail,
			List<Role> role) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.roles = role;
	}
	
}
