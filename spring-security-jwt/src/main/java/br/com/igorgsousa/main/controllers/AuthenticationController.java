package br.com.igorgsousa.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.igorgsousa.main.model.domain.User;
import br.com.igorgsousa.main.model.dto.AuthenticateRequestDto;
import br.com.igorgsousa.main.model.dto.AuthenticateResponseDto;
import br.com.igorgsousa.main.security.JwtTokenUtil;
import br.com.igorgsousa.main.service.UserService;

@RestController
@CrossOrigin
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UserService userService;

	@PostMapping(value  = "/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody AuthenticateRequestDto requestDto) throws Exception {
		
		//Autentica o usuario
		authenticate(requestDto.getUsername(), requestDto.getPassword());
		
		//Busca o userDetails para geracao do token
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(requestDto.getUsername());
		//Gera o token
		String token = jwtTokenUtil.generateToken(userDetails);
		
		
		//Busca os dados do usuario
		User user = this.userService.findUserByUsername(requestDto.getUsername());
		
		//Insere o token e as informacoes do usuario na resposta
		return ResponseEntity.ok(new AuthenticateResponseDto(token, user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}