package boot.service;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

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
import boot.entity.User_info;
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
	public User_info save(UserRegistrationDto registrationDto) {
		User_info user = new User_info();
		user.setFull_name(registrationDto.getFirstName()+registrationDto.getLastName());
		user.setEmail(registrationDto.getEmail());
//		BCryptPasswordEncoder passwordEncoder =(BCryptPasswordEncoder) passwordEncoder1();
		user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
		user.setAddress(null);
		user.setPoint(0);
		user.setPhone(null);
		Role role = roleRepository.findByRoleName("ROLE_ADMIN");
		 if(role == null){
	            role = checkRoleExist();
	        }
	    user.setRoles(Arrays.asList(role));
	    
		return userRepository.save(user);
	}
	private Role checkRoleExist(){
        Role role = new Role();
        role.setRoleName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

	@Override
	public User_info findUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}


}
