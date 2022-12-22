package boot.service;

import boot.dto.UserRegistrationDto;
import boot.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
	User findUserByEmail(String email);
	void updateResetPasswordToken(String token, String email) throws Exception;
	User getByResetPasswordToken(String token);
	void updatePassword(User customer, String newPassword);

	List<User> findAll();
}
