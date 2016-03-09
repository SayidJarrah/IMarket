package com.dkorniichuk.app.controller;

import com.dkorniichuk.app.entity.ProductCategory;
import com.dkorniichuk.app.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;


@Controller
@RequestMapping("/admin/addNewCategory")
public class NewCategoryController {
    @Autowired
    private ProductCategoryService categoryService;


    @RequestMapping(method = RequestMethod.GET)
    public String initCategoryForm(Model model) {
        model.addAttribute("category", new ProductCategory());
        return "addNewCategory";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitCategoryForm(ProductCategory category) throws IOException {
        categoryService.save(category);
        return "hello";
    }
}