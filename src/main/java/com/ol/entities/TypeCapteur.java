package com.ol.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeCapteur {
	
	/**
     * id du role
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * nom du TypeCapteur
     */
    private String libelle;

    /**
     * constructeur
     * @param libelle nom du TypeCapteur
     */
    public TypeCapteur(String libelle){
        this.libelle = libelle;

    }

}
