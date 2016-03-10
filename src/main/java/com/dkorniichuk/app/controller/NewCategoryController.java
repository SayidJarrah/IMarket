package com.dkorniichuk.app.controller;

import com.dkorniichuk.app.entity.ProductCategory;
import com.dkorniichuk.app.service.ProductCategoryService;
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
    public @ResponseBody ProductCategory addCategory(@RequestBody ProductCategory category) throws IOException {
        String returnText;

            categoryService.save(category);
            returnText = "User has been added to the list. Total number of users are ";

        return category;
    }
}
