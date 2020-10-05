package com.ol.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Capteur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomCapteur;
	private String apiKey;
	@ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
	private TypeCapteur typeCapteur;
	@ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Utilisateur utilisateur;
	public Capteur(String nomCapteur, String apiKey, TypeCapteur typeCapteur, Utilisateur utilisateur) {
		super();
		this.nomCapteur = nomCapteur;
		this.apiKey = apiKey;
		this.typeCapteur = typeCapteur;
		this.utilisateur = utilisateur;
	}

}
