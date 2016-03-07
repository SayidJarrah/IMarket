package com.dkorniichuk.app.controller;

import com.dkorniichuk.app.entity.User;
import com.dkorniichuk.app.service.OrderService;
import com.dkorniichuk.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String initRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String submitRegistration(User user) throws IOException {
        userService.add(user);
        return "hello";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String initProfile(Model model) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user", userService.get(login));
        return "profile";
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String initPurchaseHistory(Model model) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("orders", orderService.getByUser(userService.get(login)));
        System.out.println(orderService.getByUser(userService.get(login)));
        return "history";
    }

}
