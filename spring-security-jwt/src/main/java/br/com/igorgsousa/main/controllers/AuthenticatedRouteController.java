package br.com.igorgsousa.main.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/authenticated-route")
public class AuthenticatedRouteController {
	
	@GetMapping
	public String getMessage() {
		return "Esta eh uma rota autenticada e eh necessario estar autenticado para buscar este recurso";
	}
}
