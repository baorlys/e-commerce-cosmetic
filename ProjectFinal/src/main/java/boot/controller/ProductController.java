package boot.controller;

import boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class ProductController {
    @Autowired
    ProductService productService;



}
