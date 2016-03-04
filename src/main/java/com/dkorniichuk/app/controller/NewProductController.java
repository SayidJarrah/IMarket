package com.dkorniichuk.app.controller;

import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.service.ProductCategoryService;
import com.dkorniichuk.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/admin/addNewProduct.html")
public class NewProductController {
    @Autowired
    private ProductCategoryService categoryService;

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String initProductForm(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "addNewProduct";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitProductForm(Model model, Product product, @RequestParam("file") MultipartFile file) throws IOException {
        model.addAttribute("product",product);
        productService.binding(product);
        product.setImage(file.getBytes());
        System.out.println(product);
        productService.save(product);
        return "redirect:/public/products.html";
    }




}
