package com.demo.CustomerMS.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.CustomerMS.entity.Customer;
import com.demo.CustomerMS.exception.DuplicateResourceException;
import com.demo.CustomerMS.exception.NoResourceFoundException;
import com.demo.CustomerMS.service.ICustomerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/api/customers")
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
	
		Customer c = customerService.getById(id)
				.orElseThrow(() -> new NoResourceFoundException("Customer with id " + id + " not found."));
		return c;
		
	}
	
	@PostMapping
	public ResponseEntity<Customer> save(@RequestBody Customer customer) throws URISyntaxException {
		Optional<Customer> oCustomer = customerService.findByEmail(customer.getEmail());
		if(oCustomer.isPresent()) {
			logger.error("Customer with {}"+ customer.getEmail()+ " already exists in the system");
			throw new DuplicateResourceException("Customer with " + customer.getEmail() + " already exists in the system");
		}
		customer = customerService.add(customer);
		return ResponseEntity.created(new URI("/api/customers/" + customer.getId())).body(customer);
	}
	
	
	public Customer getCustomerFallback(Long id) 
	{
		
		logger.error("In fallback method when accessing id :"+ id);
		return new Customer();
		
		
	}
}
