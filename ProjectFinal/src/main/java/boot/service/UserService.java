package boot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import boot.dto.UserRegistrationDto;
import boot.entity.UserInfo;


public interface UserService {
	UserInfo save(UserRegistrationDto registrationDto);

	UserInfo findUserByEmail(String email);
}
