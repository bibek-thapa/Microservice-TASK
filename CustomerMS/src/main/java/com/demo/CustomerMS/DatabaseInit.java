package com.demo.CustomerMS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.CustomerMS.entity.Customer;
import com.demo.CustomerMS.repository.ICustomerRepository;

@Component
public class DatabaseInit {
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	@PostConstruct
	private void postConstruct() 
	{
		List<Customer> customerList = new ArrayList<>();
		Customer customer1 = new Customer(1l,"Ram","Thapa","ram@gmail.com");
		Customer customer2 = new Customer(2l, "Hari", "Neupane","hari@gmail.com");
		Customer customer3 = new Customer(3l, "Ramila", "Karki","ramila@gmail.com");
		Customer customer4 = new Customer(4l, "David", "Yonge","david@gmail.com");
		Customer customer5 = new Customer(5l, "Peter", "Parker","peter@gmail.com");
		
		Customer[] customers = new Customer[] {customer1, customer2, customer3, customer4,customer5};
		customerList.addAll(Arrays.asList(customers));
		customerRepository.saveAll(customerList);
	}

}
