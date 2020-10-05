package com.ol.entities.postbody;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

import com.ol.entities.TypeCapteur;
import com.ol.entities.vues.CapteurVue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CapteurPost {

	private String nomCapteur;
	private String typeCapteur;
	
}
