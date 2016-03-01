package com.dkorniichuk.app.controller;


import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

    @RequestMapping("/search")
    public String initSearchForm() {
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public void submitSearch(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String keyword = request.getParameter("keyword");
        List<Product> list = productService.search(keyword);
        for (Product product : list){
            response.getOutputStream().println(product.getId()+" "+product.getName()+" "+product.getPrice());
        }
      //  return "hello";
    }


}
