package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customer-form/{id}")
    public ModelAndView moveCreatePage(@PathVariable int id) {
        System.out.println(id);
        ModelAndView modelAndView = new ModelAndView("create");
        if (id == 0){
            modelAndView.addObject("customer", new Customer());
            return modelAndView;
        }
        Customer customer1 = customerService.findById(id);
        modelAndView.addObject("customer", customer1);
        return modelAndView;
    }

    @PostMapping("/customer-form")
    public ModelAndView handCustomer(@ModelAttribute Customer customer, @RequestParam String action) {
        switch (action) {
            case "create":
                return createCustomer(customer);

            case "edit":
              return   createCustomer(customer);
        }
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;

    }

    public ModelAndView createCustomer(Customer customer) {
        ModelAndView modelAndView = new ModelAndView("create");
        Customer customer1 = customerService.save(customer);
        if (customer1 != null) {
            modelAndView.addObject("message", "save thanh cong");
        } else {
            modelAndView.addObject("message", "save that bai");
        }
        return modelAndView;
    }
//    public ModelAndView editCustomer(Customer customer) {
//        ModelAndView modelAndView = new ModelAndView("create");
//        Customer customer1 = customerService.save(customer);
//        if (customer1 != null) {
//            modelAndView.addObject("message", " edit thanh cong");
//        } else {
//            modelAndView.addObject("message", "edit that bai");
//        }
//        return modelAndView;
//    }

}