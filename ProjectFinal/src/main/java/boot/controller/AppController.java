package boot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boot.dto.UserRegistrationDto;
import boot.entity.UserInfo;
import boot.repository.UserRepository;
import boot.security.CustomUserDetails;
import boot.service.UserService;

@Controller

public class AppController {
	
	
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;
	
	public AppController(UserService userService,PasswordEncoder passwordEncoder) {
		super();
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@RequestMapping("/login")
	public String Login() {
		return "SignIn";
	}
	
	@RequestMapping("/")
	public String viewHomePage(@AuthenticationPrincipal CustomUserDetails user ,Model model) {
		String pageTitle = "Cửa hàng mỹ phẩm";
		model.addAttribute("pageTitle",pageTitle);
		model.addAttribute("user", user);
		if(user == null) {
			
			return "redirect:/index";
		}
		return "redirect:/index?login";
	}
	
	@RequestMapping("/account")
	public ModelAndView viewAccount(@AuthenticationPrincipal CustomUserDetails user,Model model) {
		ModelAndView mav = new ModelAndView("User_Setting");
		UserInfo a = userService.findUserByEmail(user.getUsername());
		mav.addObject("user", a);
		return mav;
	}
	
	
	
	@RequestMapping(value = "account/save", method = RequestMethod.POST)
	public String EditUser(@ModelAttribute("user") UserInfo user,Model model) {
		
		UserInfo a = userRepository.findByEmail(user.getEmail());
		a.setAddress(user.getAddress());
		a.setPhone(user.getPhone());
		a.setFullName(user.getFullName());
		userRepository.save(a);
		return "redirect:/account?success";
	}
	
	@RequestMapping(value = "account/changePass", method = RequestMethod.POST)
	public String ChangePass(@ModelAttribute("user") UserInfo user,String oldpass,String pass, String passConfirm,Model model) {
		UserInfo a = userRepository.findByEmail(user.getEmail());
		
		if(!passwordEncoder.matches(oldpass, a.getPassword())) {
			return "redirect:/account?OldPassNotCorrect";
			
		}else {
			if(!pass.equals(passConfirm)) {
				return "redirect:/account?ConfirmNotCorrect";
			}
			else {
				if(oldpass.equals(pass)) {
					return "redirect:/account?SameOldPass";
				}
				else {
					a.setPassword(passwordEncoder.encode(pass));
					userRepository.save(a);
					return "redirect:/account?changesuccessfull";
				}
			}
		}
		
	}
	
	@RequestMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserRegistrationDto user = new UserRegistrationDto();
        model.addAttribute("user", user);
        return "SignUp";
    }
	
	@RequestMapping(value = "register/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("user") UserRegistrationDto userRegistrationDto,
										BindingResult result,
										Model model) {
		UserInfo existingUser = userService.findUserByEmail(userRegistrationDto.getEmail());
		
		if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", 
            					null,"There is already an account registered with the same email");
        }
		
		if(result.hasErrors()) {
			model.addAttribute("user",userRegistrationDto);
			return "redirect:/register?fail";
		}
		userService.save(userRegistrationDto);
		if(userService.findUserByEmail("admin@gmail.com") == null) {
			userService.admin();
		}
		return "redirect:/register?success";
	}


	@RequestMapping("/index")
	public String homepage(Model model) {
		String pageTitle = "Cửa hàng mỹ phẩm";
		model.addAttribute("pageTitle",pageTitle);
		return "index";
	}
	
}
