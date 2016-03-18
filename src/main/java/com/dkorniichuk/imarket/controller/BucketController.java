package com.dkorniichuk.imarket.controller;

import com.dkorniichuk.imarket.entity.Product;
import com.dkorniichuk.imarket.service.BucketService;
import com.dkorniichuk.imarket.service.OrderService;
import com.dkorniichuk.imarket.service.ProductService;
import com.dkorniichuk.imarket.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BucketController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private BucketService bucketService;
    private static final Logger logger = LoggerFactory.getLogger(BucketController.class);



    @RequestMapping(value = "/bucket", method = RequestMethod.GET)
    public String initBucket(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("products", bucketService.get(auth.getName()));
        logger.info("loaded bucket page");
        return "bucket";
    }

    @RequestMapping(value = "/bucket/{id}", method = RequestMethod.GET)
    public String deleteFromBucket(@PathVariable("id") int id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        logger.info("{} deleted product with id from bucket product {}",auth.getName(), id);
        bucketService.delete(auth.getName(),productService.getProductById(id));
        return "redirect:/bucket";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String initOrder(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Product> products = bucketService.get(auth.getName());
        productService.updateAmount(products);
        logger.info("ordered products {}", products);
        orderService.add(products, userService.get(auth.getName()));
        model.addAttribute("products", products);
        return "order";
    }

    @RequestMapping(value = "/cleanBucket", method = RequestMethod.GET)
    public String cleanBucket() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        bucketService.clear(auth.getName());
        logger.info("bucket cleaned");
        return "redirect:/products";
    }


    @RequestMapping(value = "/bucket",method = RequestMethod.POST)
    public void addToBucket(@RequestParam("id") Integer id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        bucketService.add(auth.getName(),productService.getProductById(id));
        logger.info("product added to bucket");
    }
}