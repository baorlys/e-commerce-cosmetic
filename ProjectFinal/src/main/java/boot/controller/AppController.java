package boot.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import boot.dto.UserRegistrationDto;
import boot.entity.User_info;
import boot.service.UserService;

@Controller

public class AppController {
	
	
	private UserService userService;
	
	
	public AppController(UserService userService) {
		super();
		this.userService = userService;
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
		User_info existingUser = userService.findUserByEmail(userRegistrationDto.getEmail());
		
		if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", 
            					null,"There is already an account registered with the same email");
        }
		
		if(result.hasErrors()) {
			model.addAttribute("user",userRegistrationDto);
			return "redirect:/register?fail";
		}
		userService.save(userRegistrationDto);
		return "redirect:/register?success";
	}
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		return "index";
	}
	@RequestMapping("/yeah")
	public String viewYeahPage(Model model) {
		return "yeah";
	}
	@RequestMapping("/login")
	public String Login() {
		return "SignIn";
	}
}
