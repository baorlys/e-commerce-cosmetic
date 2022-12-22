package boot.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import boot.dto.UserRegistrationDto;
import boot.entity.Role;
import boot.entity.User;
import boot.repository.RoleRepository;
import boot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User();
		user.setFullName(registrationDto.getFullName());
		user.setEmail(registrationDto.getEmail());
		user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
		user.setAddress(null);
		user.setPoint(0);
		user.setPhone(null);
		user.setResetPasswordToken(null);
		Role role = roleRepository.findByRoleName("user");
		if(role == null){
			role= checkRoleExist();
		}
	    user.setRoles(Arrays.asList(role));
	    
		return userRepository.save(user);
	}
	private Role checkRoleExist(){
        Role role = new Role();
        role.setRoleName("user");
        return roleRepository.save(role);
    }

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}


	@Override
	public void updateResetPasswordToken(String token, String email) throws Exception {
		User user = userRepository.findByEmail(email);
		if(user != null) {
			user.setResetPasswordToken(token);
			userRepository.save(user);
		}else {
			throw new Exception("Could not find any user with the email "+email);
		}
		
	}


	@Override
	public User getByResetPasswordToken(String token) {
		
		return userRepository.findByResetPasswordToken(token);
	}


	@Override
	public void updatePassword(User user, String newPassword) {
		String endcodedPassword = passwordEncoder.encode(newPassword);
		user.setPassword(endcodedPassword);
		
		user.setResetPasswordToken(null);
		userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Sai email hoặc mật khẩu");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}
}
