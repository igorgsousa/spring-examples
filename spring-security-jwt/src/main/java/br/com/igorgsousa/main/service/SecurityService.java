package br.com.igorgsousa.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.igorgsousa.main.model.domain.User;

@Component
public class SecurityService implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	    	
    	User user = this.userService.findUserByUsername(username);
    	
    	if(user == null) {
            throw new UsernameNotFoundException(username + " nao encontrado");
        }
    	
        org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRoles())
        );
		return userDetails;
    }
}