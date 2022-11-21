package boot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import boot.dto.UserRegistrationDto;
import boot.entity.User_info;


public interface UserService {
	User_info save(UserRegistrationDto registrationDto);
	
	User_info findUserByEmail(String email);
}
