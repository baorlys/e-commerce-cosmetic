package boot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import boot.dto.UserRegistrationDto;
import boot.entity.UserInfo;


public interface UserService {
	UserInfo save(UserRegistrationDto registrationDto);
	UserInfo admin();
	UserInfo findUserByEmail(String email);
	void updateResetPasswordToken(String token, String email) throws Exception;
	UserInfo getByResetPasswordToken(String token);
	void updatePassword(UserInfo customer, String newPassword);
}
