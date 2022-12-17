package boot.controller;

import boot.entity.Product;
import boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }

    @RequestMapping("/store")
    public String store(Model model) {
        List<Product> productList = productService.getAll();
        model.addAttribute("productList", productList);
        return "customer/store";
    }

    @RequestMapping("/store/product/{id}")
    public String productInfo(@PathVariable("id") long id, Model model) {
        Optional<Product> product = productService.findById(id);
        model.addAttribute("product",product.get());
        return "customer/product";
    }


}
