package boot.controller;

import boot.entity.Product;
import boot.entity.TransItem;
import boot.entity.Transaction;
import boot.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private ProductService productService;
    private CartService cartService;
    private TransactionService transactionService;

    private TransItemService transItemService;

    public AdminController(UserService userService, ProductService productService, CartService cartService, TransactionService transactionService, TransItemService transItemService) {
        super();
        this.cartService = cartService;
        this.userService = userService;
        this.productService = productService;
        this.transactionService = transactionService;
        this.transItemService = transItemService;
    }

    @RequestMapping("/transDetail/{transId}")
    public String transDetail(@PathVariable("transId") long transId, Model model) {
        Transaction trans = transactionService.findById(transId).get();
        List<TransItem> transItemList = transItemService.findByTrans(trans);
        int totalPrice = 0;
        for (TransItem item: transItemList) {
            totalPrice += item.getQuantity() * item.getProduct().getPrice();
        }
        model.addAttribute("totalPrice",totalPrice);
        model.addAttribute("trans",trans);
        model.addAttribute("transItemList", transItemList);
        return "admin/trans_detail";
    }

    @RequestMapping("/confirmTrans/{transId}")
    public String confirmTrans(@PathVariable("transId") long transId, Model model) {
        transactionService.confirm(transId);
        model.addAttribute("transList",transactionService.findByStatusIs(0));
        return "redirect:/account";
    }

    @RequestMapping("/cancelTrans/{transId}")
    public String cancelTrans(@PathVariable("transId") long transId, Model model) {
        transactionService.cancel(transId);
        model.addAttribute("transList",transactionService.findByStatusIs(0));
        return "redirect:/account";
    }

    @RequestMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") Product product, Model model) {
        productService.create(product);
        List<Product> productList = productService.getAll();
        model.addAttribute("productList", productList);
        return "redirect:/account/admin_product";
    }

    @RequestMapping("/addProductForm")
    public String addProductForm(Model model) {
        model.addAttribute("product",new Product());
        return "admin/add_product";
    }

    @RequestMapping("/updateProductForm/{productId}")
    public String updateProductForm(@PathVariable("productId") long productId, Model model) {
        model.addAttribute("product",productService.findById(productId).get());
        return "admin/update_product";
    }

    @RequestMapping("/updateProduct/{productId}")
    public String updateProduct(@PathVariable("productId") long productId, @ModelAttribute("product") Product product, Model model) {
        productService.update(productId, product);
        List<Product> productList = productService.getAll();
        model.addAttribute("productList", productList);
        return "redirect:/account/admin_product";
    }

    @RequestMapping("/removeProduct/{productId}")
    public String removeProduct(@PathVariable("productId") long productId) {
        productService.deleteById(productId);
        return "redirect:/account/admin_product";
    }


}
