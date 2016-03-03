package com.dkorniichuk.app.controller;

import com.dkorniichuk.app.entity.Bucket;
import com.dkorniichuk.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BucketController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/bucket",method = RequestMethod.GET)
    public String initBucketForm(Model model) {
        model.addAttribute("products", Bucket.getINSTANCE().getProducts());
        return "bucket";
    }

    @RequestMapping(value = "/bucket/{id}",method = RequestMethod.GET)
    public String  addToBucket(@PathVariable("id") int id){
        Bucket.getINSTANCE().delete(productService.getProductById(id));
        return "redirect:/bucket";
    }
}
