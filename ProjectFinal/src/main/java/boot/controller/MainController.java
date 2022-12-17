package boot.controller;

import java.util.List;


import boot.entity.Product;
import boot.entity.User;
import boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import boot.repository.UserRepository;
import boot.service.UserService;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class MainController {


	private UserService userService;
	private ProductService productService;



	public MainController(UserService userService, ProductService productService) {
		super();
		this.userService = userService;
		this.productService = productService;
	}

	@RequestMapping("/login")
	public String Login() {

		return "login";
	}

	@RequestMapping("/")
	public String home(Model model) {
		List<Product> productList = productService.getAll();
		model.addAttribute("productList", productList);
		return "index";
	}
	@RequestMapping("/index")
	public String homepage(Model model) {
		List<Product> productList = productService.getAll();
		model.addAttribute("productList", productList);
		return "index";
	}

	@RequestMapping("/store")
	public String store(Model model) {
		List<Product> productList = productService.getAll();
		model.addAttribute("productList", productList);
		return "customer/store";
	}

	@RequestMapping("/store/product/{id}")
	public String productInfo(@PathVariable("id") long id, Model model) {
		Product product = productService.findById(id);
		model.addAttribute("product",product);
		return "product";
	}




	@RequestMapping("/account")
	public ModelAndView viewAccount(@AuthenticationPrincipal UserDetails user, Model model) {
		ModelAndView mav = new ModelAndView("customer/user_setting");
		User userLogin = userService.findUserByEmail(user.getUsername());
		mav.addObject("user", userLogin);
		return mav;
	}
//
//
//
//	@RequestMapping(value = "account/save", method = RequestMethod.POST)
//	public String EditUser(@ModelAttribute("user") User user, Model model) {
//
//		User a = userRepository.findByEmail(user.getEmail());
//		a.setAddress(user.getAddress());
//		a.setPhone(user.getPhone());
//		a.setFullName(user.getFullName());
//		userRepository.save(a);
//		return "redirect:/account?success";
//	}
//
//	@RequestMapping(value = "account/changePass", method = RequestMethod.POST)
//	public String ChangePass(@ModelAttribute("user") User user, String oldpass, String pass, String passConfirm, Model model) {
//		User a = userRepository.findByEmail(user.getEmail());
//
//		if(!passwordEncoder.matches(oldpass, a.getPassword())) {
//			return "redirect:/account?OldPassNotCorrect";
//
//		}else {
//			if(!pass.equals(passConfirm)) {
//				return "redirect:/account?ConfirmNotCorrect";
//			}
//			else {
//				if(oldpass.equals(pass)) {
//					return "redirect:/account?SameOldPass";
//				}
//				else {
//					a.setPassword(passwordEncoder.encode(pass));
//					userRepository.save(a);
//					return "redirect:/account?changesuccessfull";
//				}
//			}
//		}
//
//	}
//




	//Test
	@RequestMapping("/test")
	public String test(Model model) {
		List<Product> productList = productService.getAll();
		int a = productList.size();
		model.addAttribute("productsList", productList);
		return "product";
	}
}
