package com.dkorniichuk.app.controller;


import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public String allProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String showProductDetails(@RequestParam("id") Integer id, Model model) throws IOException {
        Product product = productService.getProductById(id);
        model.addAttribute(product);
        return "detail";
    }


}
