package com.dkorniichuk.app.controller;

import com.dkorniichuk.app.dao.UserDao;
import com.dkorniichuk.app.entity.Bucket;
import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.service.OrderService;
import com.dkorniichuk.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BucketController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserDao userDao;


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

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public String  initOrder(Model model){
        List<Product> products = Bucket.getINSTANCE().getProducts();
        productService.updateAmount(products);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        orderService.add(Bucket.getINSTANCE().getProducts(),userDao.getUser(auth.getName()));
        model.addAttribute("products", products);
        return "order";

    }
}
