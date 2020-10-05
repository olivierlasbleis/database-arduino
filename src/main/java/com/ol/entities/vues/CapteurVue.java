package com.ol.entities.vues;

import com.ol.entities.TypeCapteur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CapteurVue {

	private String nomCapteur;
	private String typeCapteur;
	private String apiKey;
	
}
