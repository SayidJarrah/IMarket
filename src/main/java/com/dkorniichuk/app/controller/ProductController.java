package com.dkorniichuk.app.controller;


import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.service.ProductCategoryService;
import com.dkorniichuk.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService categoryService;

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

    @RequestMapping(value = "/addProduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories",categoryService.getAllCategory());
        return "addNewProduct";
    }

    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    public String createProduct(Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(product); //TODO: add smth
            return "addNewProduct";
        } else {
            productService.save(product);
            return "addNewProduct";
        }
    }
}
