package br.com.igorgsousa.main.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.igorgsousa.main.model.dto.AnimalDto;

@RestController
@RequestMapping("/animal")
public class AnimalController {
	
	@GetMapping
	public ResponseEntity<List<AnimalDto>> list(){
		List<AnimalDto> data = new ArrayList<AnimalDto>();
	    
		data.add(new AnimalDto("Dragao de Komodo", "Varanus komodoensis"));
		data.add(new AnimalDto("Mosquito da dengue", "Aedes aegypti"));
		
		ResponseEntity<List<AnimalDto>> ret = ResponseEntity.ok(data);
		return ret;
	}
	
}
