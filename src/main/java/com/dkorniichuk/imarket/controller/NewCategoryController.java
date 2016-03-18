package com.dkorniichuk.imarket.controller;

import com.dkorniichuk.imarket.entity.ProductCategory;
import com.dkorniichuk.imarket.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public
    @ResponseBody
    ProductCategory addCategory(@RequestBody ProductCategory category) throws IOException {
        categoryService.save(category);
        return category;
    }
}
