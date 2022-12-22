package boot.controller;

import java.util.*;


import boot.dto.CartItem;
import boot.entity.Product;
import boot.entity.Role;
import boot.entity.User;
import boot.service.*;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller

public class MainController {


	private UserService userService;
	private ProductService productService;
	private CartService cartService;
	private TransactionService transactionService;

	private TransItemService transItemService;

	public MainController(UserService userService, ProductService productService, CartService cartService, TransactionService transactionService, TransItemService transItemService) {
		super();
		this.cartService = cartService;
		this.userService = userService;
		this.productService = productService;
		this.transactionService = transactionService;
		this.transItemService = transItemService;
	}

	@RequestMapping("/login")
	public String Login() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}

		return "index";
	}



	@RequestMapping(value = {"/index","/"})
	public String homepage(Model model, @AuthenticationPrincipal UserDetails user) {
		List<Product> productList = productService.getAll();
		Collection<CartItem> cartItems = cartService.getCartItems();
		model.addAttribute("cartItems",cartItems);
		productList.removeIf(product -> product.getAmount() == 0);
		Collections.sort(productList, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				return o2.getProductId().compareTo(o1.getProductId());
			}
		});
		if (user != null) {
			model.addAttribute("roleId",getRoleCurrent(user));
		}
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
			mav.addObject("transList",transactionService.findByStatusIs(0));
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

	private long getRoleCurrent(@AuthenticationPrincipal UserDetails user) {
		User userLogin = userService.findUserByEmail(user.getUsername());
		Collection<Role> roles = userLogin.getRoles();
		long roleId = roles.iterator().next().getRoleId();
		return roleId;
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
