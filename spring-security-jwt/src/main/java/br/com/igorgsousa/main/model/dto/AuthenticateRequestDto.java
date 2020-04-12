package br.com.igorgsousa.main.model.dto;

import lombok.Data;

@Data
public class AuthenticateRequestDto {
	
	private String username;
	private String password;
	
}
