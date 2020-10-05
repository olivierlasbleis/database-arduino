package com.ol.entities.postbody;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MesurePost {
	
	private Double valeur;
	private LocalDateTime date;

}
