package com.dkorniichuk.imarket.controller;

import com.dkorniichuk.imarket.entity.Product;
import com.dkorniichuk.imarket.service.ProductCategoryService;
import com.dkorniichuk.imarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/admin/addNewProduct")
public class NewProductController {
    @Autowired
    private ProductCategoryService categoryService;

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String initProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "addNewProduct";
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    Product addProduct(@RequestBody Product product) throws IOException {
        productService.binding(product);
        product.setImage(productService.loadImageFromTemporaryRepo());
        productService.save(product);
        return product;
    }
}
