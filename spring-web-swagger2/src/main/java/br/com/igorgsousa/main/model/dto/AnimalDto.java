package br.com.igorgsousa.main.model.dto;

import lombok.Data;

@Data
public class AnimalDto {
	
	private String popularName;
	private String scientificName;

	public AnimalDto( String popularName, String scientificName) {
		this.popularName = popularName;
		this.scientificName = scientificName;
	}
	
}
