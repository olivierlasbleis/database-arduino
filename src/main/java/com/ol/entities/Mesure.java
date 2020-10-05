package com.ol.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mesure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double valeur;
	private LocalDateTime date;
	@ManyToOne
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Capteur capteur;
	public Mesure(Double valeur, LocalDateTime date) {
		super();
		this.valeur = valeur;
		this.date = date;
	}
}
