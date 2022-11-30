package boot.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User {
	private String fullname;
	public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,String fullname) {
		super(username, password, authorities);
		this.fullname = fullname;
	}

	public String getFullName() {
		return fullname;
	}
}
