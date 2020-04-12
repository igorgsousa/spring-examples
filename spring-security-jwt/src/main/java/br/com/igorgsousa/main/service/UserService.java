package br.com.igorgsousa.main.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.igorgsousa.main.model.domain.User;

@Service
public class UserService {
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	private List<User> users;
	
	
	@PostConstruct
	public void init() {
		this.users = new ArrayList<>();
		this.users.add(new User("admin", this.passwordEncoder.encode("123456")));
		this.users.add(new User("admin2", this.passwordEncoder.encode("654321")));
	}
	
    public User findUserByUsername(String username) {
    	
    	User ret = null;
    	
    	int indexOfUser = this.users.indexOf(new User(username));
    	
    	if(indexOfUser != -1) {
           ret = this.users.get(indexOfUser);
        }
    	
		return ret;
    }
}