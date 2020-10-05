package com.ol.entities.vues;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MesureVue {
	
	private Double valeur;
	private LocalDateTime date;

}
