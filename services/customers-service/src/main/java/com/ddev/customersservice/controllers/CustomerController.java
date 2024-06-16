package com.ddev.customersservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/customers")
public class CustomerController {

    @GetMapping
    public String getCustomer() {
        return "Customer Returned!";
    }

}
