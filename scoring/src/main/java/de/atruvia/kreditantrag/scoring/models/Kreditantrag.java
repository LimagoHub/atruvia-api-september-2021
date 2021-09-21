package de.atruvia.kreditantrag.scoring.models;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@JsonIgnoreProperties(ignoreUnknown = true)
public class Kreditantrag {

	
	@Id
	
	private String id;
	

	private double einkommen;
	
	
	private double ausgaben;
	

	private double kreditWunsch;
	
	
	public boolean istKreditWuerdig() {
		return einkommen > ausgaben;
	}
	
}
