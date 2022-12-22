package boot.controller;

import boot.dto.CartItem;
import boot.entity.Product;
import boot.entity.TransItem;
import boot.entity.Transaction;
import boot.entity.User;
import boot.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

@Controller
@RequestMapping("shoppingCart")
public class CartController {
    private UserService userService;
    private ProductService productService;
    private CartService cartService;
    private TransactionService transactionService;

    private TransItemService transItemService;
    public CartController(ProductService productService, CartService cartService, UserService userService, TransactionService transactionService, TransItemService transItemService) {
        this.productService = productService;
        this.cartService = cartService;
        this.userService = userService;
        this.transactionService = transactionService;
        this.transItemService = transItemService;
    }
    @GetMapping("cart")
    public String list(Model model,  @AuthenticationPrincipal UserDetails user) {
        Collection<CartItem> cartItems = cartService.getCartItems();
        model.addAttribute("cartItems",cartItems);
        int totalPrice = cartService.getTotalPrice();
        model.addAttribute("totalPrice",totalPrice);
        User userLogin = userService.findUserByEmail(user.getUsername());
        model.addAttribute("user", userLogin);
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

    @GetMapping("remove/{productId}")
    public String remove(@PathVariable("productId") long productId) {
        cartService.remove(productId);
        return "redirect:/shoppingCart/cart";
    }

    @PostMapping("update")
    public String update(@RequestParam("productId") long productId, @RequestParam("quantity") int quantity) {
        cartService.update(productId,quantity);
        return "redirect:/shoppingCart/cart";
    }

    @GetMapping("clear")
    public String clear() {
        cartService.clear();
        return "redirect:/shoppingCart/cart";
    }

    @PostMapping("checkout")
    public String checkOut(@RequestParam("address") String address,
                           @RequestParam("phone") String phone,
                           @AuthenticationPrincipal UserDetails user,
                           RedirectAttributes redirAttrs) {
        Collection<CartItem> cartItems = cartService.getCartItems();
        User userLogin = userService.findUserByEmail(user.getUsername());
        Transaction trans = new Transaction();
        trans.setTransAddress(address);
        trans.setTransDate(new Date());
        trans.setUser(userLogin);
        trans.setStatus(0);
        transactionService.save(trans);
        for(CartItem item : cartItems) {
            TransItem transItem = new TransItem();
            transItem.setTransaction(trans);
            transItem.setProduct(item.getProduct());
            transItem.setQuantity(item.getQuantity());
            transItemService.save(transItem);
        }
        redirAttrs.addFlashAttribute("message", "đơn hàng được tạo thành công");
        cartService.clear();
        return "redirect:/index";
    }







}
