package br.com.igorgsousa.main.model.domain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class User {
	
	private String username;
	private String password;
	
	public String[] getRoles() {
		return new String[]{"USER"};
	}


	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(String username) {
		this(username,null);
	}


	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equalsIgnoreCase(other.username))
			return false;
		return true;
	}
}
