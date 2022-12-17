package boot.controller;

import boot.dto.CartItem;
import boot.entity.Product;
import boot.entity.User;
import boot.service.CartService;
import boot.service.ProductService;
import boot.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("shoppingCart")
public class CartController {
    private UserService userService;
    private ProductService productService;
    private CartService cartService;
    public CartController(ProductService productService, CartService cartService, UserService userService) {
        this.productService = productService;
        this.cartService = cartService;
        this.userService = userService;
    }
    @GetMapping("cart")
    public String list(Model model) {
        Collection<CartItem> cartItems = cartService.getCartItems();
        model.addAttribute("cartItems",cartItems);
        int totalPrice = cartService.getTotalPrice();
        model.addAttribute("totalPrice",totalPrice);
        return "shoppingCart/cart";
    }

    @GetMapping("add/{productId}")
    public String add(@PathVariable("productId") long productId) {
        Product product = productService.findById(productId).get();
        CartItem item = new CartItem(product,1);
        item.setProduct(product);
        cartService.add(item);
        return "redirect:/shoppingCart/cart";
    }

    @GetMapping("remove")
    public String remove() {
        return "redirect:/shoppingCart/cart";
    }

    @PostMapping("update")
    public String update() {
        return "redirect:/shoppingCart/cart";
    }

    @GetMapping("clear")
    public String clear() {
        return "redirect:/shoppingCart/cart";
    }

    @GetMapping("payment")
    public String payment(Model model, @AuthenticationPrincipal UserDetails user){
        Collection<CartItem> cartItems = cartService.getCartItems();
        model.addAttribute("cartItems",cartItems);
        int totalPrice = cartService.getTotalPrice();
        model.addAttribute("totalPrice",totalPrice);
        User userLogin = userService.findUserByEmail(user.getUsername());
        model.addAttribute("user",userLogin);
        return "customer/payment";
    }



}
