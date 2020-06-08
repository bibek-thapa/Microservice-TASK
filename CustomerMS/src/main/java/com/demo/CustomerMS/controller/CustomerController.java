package com.demo.CustomerMS.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.CustomerMS.entity.Customer;
import com.demo.CustomerMS.service.ICustomerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/api/customers/")
public class CustomerController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Value("${loggingfile}")
	private String logDir;
	
	@Autowired
	private ICustomerService customerService;

	@HystrixCommand(fallbackMethod = "getCustomerFallback")
	@GetMapping("/{id}")
	public Customer getById(@PathVariable("id")Long id) 
	{
		
		logger.info("In Profile");
		
	
		return customerService.getById(id);
		
	}
	
	
	
	public Customer getCustomerFallback(Long id) 
	{
		
		logger.error("In fallback method when accessing id :"+ id);
		logger.info("In Fallback");
		return new Customer();
		
	}
}
