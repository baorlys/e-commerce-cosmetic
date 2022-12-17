package boot.controller;

import java.util.*;


import boot.entity.Product;
import boot.entity.Role;
import boot.entity.User;
import boot.service.ProductService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
		Collections.sort(productList, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				return o2.getProductId().compareTo(o1.getProductId());
			}
		});
		model.addAttribute("productList", productList);
		return "index";
	}






	@RequestMapping("/account")
	public ModelAndView viewAccount(@AuthenticationPrincipal UserDetails user, Model model) {
		User userLogin = userService.findUserByEmail(user.getUsername());
		ModelAndView mav;
		Collection<Role> roles = userLogin.getRoles();
		long roleId = roles.iterator().next().getRoleId();
		if (roleId == 1) {
			mav = new ModelAndView("admin/index_admin");
		}
		else {
			mav = new ModelAndView("customer/user_setting");
		}
		mav.addObject("user", userLogin);
		return mav;
	}

	@RequestMapping("/account/admin_product")
	public String getProductList(Model model) {
		List<Product> productList = productService.getAll();
		model.addAttribute("productList", productList);
		return "admin/product_admin";
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
		Optional<Product> product = productService.findById(1);
		model.addAttribute("product",product.get());
		return "test";
	}
}
