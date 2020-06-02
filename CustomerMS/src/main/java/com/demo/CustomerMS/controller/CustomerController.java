package com.demo.CustomerMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.CustomerMS.entity.Customer;
import com.demo.CustomerMS.service.ICustomerService;

@RestController
@RequestMapping("/api/customers/")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;

	@GetMapping("/{id}")
	public Customer getById(@PathVariable("id")Long id) 
	{
		return customerService.getById(id);
		
	}
	
}
