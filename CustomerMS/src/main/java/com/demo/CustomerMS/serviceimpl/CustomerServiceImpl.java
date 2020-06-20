package com.demo.CustomerMS.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.CustomerMS.entity.Customer;
import com.demo.CustomerMS.exception.DuplicateResourceException;
import com.demo.CustomerMS.exception.NoResourceFoundException;
import com.demo.CustomerMS.repository.ICustomerRepository;
import com.demo.CustomerMS.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public Customer add(Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}

	@Override
	public Customer remove(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer update(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Customer> getById(Long id) {
		return customerRepository.findById(id);
	}

	@Override
	public Optional<Customer> findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

}
