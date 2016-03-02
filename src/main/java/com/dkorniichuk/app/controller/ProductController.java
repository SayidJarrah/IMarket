package com.dkorniichuk.app.controller;


import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.service.ProductCategoryService;
import com.dkorniichuk.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @RequestMapping("/search")
    public String initSearchForm() {
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String submitSearch(HttpServletRequest request,Model model) throws IOException {
        String keyword = request.getParameter("keyword");
        model.addAttribute("products",productService.search(keyword));
        return "search";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
    }
    @RequestMapping(value = "/edit")
    public String initEdit(Model model,HttpServletRequest request){
        String id = request.getParameter("id");
        model.addAttribute("product",productService.getProductById(Integer.parseInt(id)));
        model.addAttribute("categories", categoryService.getAllCategory());
        return "edit";
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void submitEdit(Product product, Model model){
        model.addAttribute("product",product);
        System.out.println(product);
        productService.update(product);
    }


}
