package com.dkorniichuk.app.controller;

import com.dkorniichuk.app.entity.Product;
import com.dkorniichuk.app.service.BucketService;
import com.dkorniichuk.app.service.OrderService;
import com.dkorniichuk.app.service.ProductService;
import com.dkorniichuk.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
        model.addAttribute("products", bucketService.get());
        logger.info("loaded bucket page");
        return "bucket";
    }

    @RequestMapping(value = "/bucket/{id}", method = RequestMethod.GET)
    public String deleteFromBucket(@PathVariable("id") int id) {
        logger.info("deleted from bucket product with id {}", id);
        bucketService.delete(productService.getProductById(id));
        return "redirect:/bucket";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String initOrder(Model model) {
        List<Product> products = bucketService.get();
        productService.updateAmount(products);
        logger.info("ordered products {}", products);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        orderService.add(products, userService.get(auth.getName()));
        model.addAttribute("products", products);
        return "order";
    }

    @RequestMapping(value = "/cleanBucket", method = RequestMethod.GET)
    public String cleanBucket() {
        bucketService.clear();
        logger.info("bucket cleaned");
        return "redirect:/products";
    }


    @RequestMapping(value = "/bucket",method = RequestMethod.POST)
    public @ResponseBody Integer addToBucket(HttpServletRequest request) {
        bucketService.add(productService.getProductById(Integer.parseInt(request.getParameter("id"))));
        logger.info("product added to bucket");
        return bucketService.get().size();
    }
}
