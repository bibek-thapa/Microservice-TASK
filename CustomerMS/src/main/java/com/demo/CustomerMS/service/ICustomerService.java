package com.demo.CustomerMS.service;

import java.util.Optional;

import com.demo.CustomerMS.entity.Customer;

public interface ICustomerService extends IGenericService<Customer>{
	Optional<Customer> findByEmail(String email);

}
