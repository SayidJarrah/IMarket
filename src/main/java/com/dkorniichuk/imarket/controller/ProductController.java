package com.dkorniichuk.imarket.controller;


import com.dkorniichuk.imarket.entity.Product;
import com.dkorniichuk.imarket.service.ProductCategoryService;
import com.dkorniichuk.imarket.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping(value = {"/", "/products"})
    public String initAllProductsForm(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        logger.info("User {} loaded product page",SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "products";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String showProductDetails(@RequestParam("id") Integer id, Model model) throws IOException {
        Product product = productService.getProductById(id);
        model.addAttribute(product);
        logger.info("User {} executed detail view for product : {}",SecurityContextHolder.getContext().getAuthentication().getPrincipal(), product);
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
        logger.info("{} executed searching by keyword : {}",SecurityContextHolder.getContext().getAuthentication().getPrincipal() ,keyword);
        return "search";
    }

    @RequestMapping(value = "/admin/edit")
    public String initEdit(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        model.addAttribute("product", productService.getProductById(Integer.parseInt(id)));
        model.addAttribute("categories", categoryService.getAllCategory());
        logger.info("loaded page for editing product with id : {}", id);
        return "edit";
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    public String submitEdit(Product product, Model model) {
        model.addAttribute("product", product);
        logger.info("{} edited information about product : {}",SecurityContextHolder.getContext().getAuthentication().getPrincipal(), product);
        productService.update(product);
        return "redirect:/products.html";
    }

    @RequestMapping(value = "/admin/search/{id}", method = RequestMethod.GET)
    public String removeProduct(@PathVariable("id") int id) {
        logger.info("{} deleted product with id : {}",SecurityContextHolder.getContext().getAuthentication().getPrincipal(), id);
        productService.delete(id);
        return "redirect:/search.html";
    }

}

