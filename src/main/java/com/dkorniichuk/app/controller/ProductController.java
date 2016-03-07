package com.dkorniichuk.app.controller;


import com.dkorniichuk.app.entity.Bucket;
import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.service.ProductCategoryService;
import com.dkorniichuk.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService categoryService;

    @RequestMapping("/public/products")
    public String initAllProductsForm(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping(value = "/public/detail", method = RequestMethod.GET)
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
    public String submitSearch(HttpServletRequest request, Model model) throws IOException {
        String keyword = request.getParameter("keyword");
        model.addAttribute("products", productService.search(keyword));
        return "search";
    }

    @RequestMapping(value = "/admin/edit")
    public String initEdit(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        model.addAttribute("product", productService.getProductById(Integer.parseInt(id)));
        model.addAttribute("categories", categoryService.getAllCategory());
        return "edit";
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    public String submitEdit(Product product, Model model) {
        model.addAttribute("product", product);
        System.out.println(product);
        productService.update(product);
        return "redirect:/public/products.html";
    }

    @RequestMapping(value = "/admin/search/{id}", method = RequestMethod.GET)
    public String removeProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/search.html";
    }

    @RequestMapping(value = "/public/products/{id}", method = RequestMethod.GET)
    public String addToBucket(@PathVariable("id") int id) {
        Bucket.getINSTANCE().add(productService.getProductById(id));
        return "redirect:/public/products";
    }

     @RequestMapping(value = "/public/products/sortAsc", method = RequestMethod.POST)
    public String sortAsc(Model model){
         model.addAttribute("products", productService.sortByPriceAsc(productService.getAllProducts()));
         return "products";
     }

    @RequestMapping(value = "/public/products/sortDesc", method = RequestMethod.POST)
    public String sortDesc(Model model){
        model.addAttribute("products", productService.sortByPriceDesc(productService.getAllProducts()));
        return "products";
    }
}

