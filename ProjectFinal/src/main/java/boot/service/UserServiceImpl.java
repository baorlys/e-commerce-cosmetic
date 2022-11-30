package boot.service;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import boot.dto.UserRegistrationDto;
import boot.entity.Role;
import boot.entity.UserInfo;
import boot.repository.RoleRepository;
import boot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	private PasswordEncoder passwordEncoder;
//	@Bean
//	public PasswordEncoder passwordEncoder1()
//	{
//	    return new BCryptPasswordEncoder();
//	}
	
	public UserServiceImpl(UserRepository userRepository,RoleRepository roleRepository,PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	public UserInfo save(UserRegistrationDto registrationDto) {
		UserInfo user = new UserInfo();
		user.setFullName(registrationDto.getFullName());
		user.setEmail(registrationDto.getEmail());
//		BCryptPasswordEncoder passwordEncoder =(BCryptPasswordEncoder) passwordEncoder1();
		user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
		user.setAddress(null);
		user.setPoint(0);
		user.setPhone(null);
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
	public UserInfo admin() {
		UserInfo user = new UserInfo();
		user.setFullName("admin");
		user.setEmail("admin@gmail.com");
		user.setPassword(passwordEncoder.encode("1234"));
		user.setAddress(null);
		user.setPoint(0);
		user.setPhone(null);
		Role role = roleRepository.findByRoleName("admin");
		if(role == null){
			role= checkAdmin();
		}
	    user.setRoles(Arrays.asList(role));
	    
		return userRepository.save(user);
	}
	private Role checkAdmin(){
        Role role = new Role();
        role.setRoleName("admin");
        return roleRepository.save(role);
    }
	@Override
	public UserInfo findUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}


}
