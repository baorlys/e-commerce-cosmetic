package boot.security;


import java.util.Collection;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import boot.entity.Role;
import boot.entity.UserInfo;
import boot.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo user = userRepository.findByEmail(username);
       
        if(user != null){
        	return new CustomUserDetails(user.getEmail()
                    , user.getPassword(),
                    user.getRoles().stream()
                            .map((role) -> new SimpleGrantedAuthority(role.getRoleName()))
                            .collect(Collectors.toList()),user.getFullName());
//            return new org.springframework.security.core.userdetails.User(user.getEmail()
//                    , user.getPassword(),
//                    user.getRoles().stream()
//                            .map((role) -> new SimpleGrantedAuthority(role.getRoleName()))
//                            .collect(Collectors.toList()));
        }else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }

    
}
