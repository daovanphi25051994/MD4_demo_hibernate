package com.codegym.controller;

import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private ICustomerService customerService;

    @RequestMapping("/")
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    @RequestMapping("/customers")
    public ModelAndView getAllCustomer(){
        ModelAndView modelAndView = new ModelAndView("customers");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }
}