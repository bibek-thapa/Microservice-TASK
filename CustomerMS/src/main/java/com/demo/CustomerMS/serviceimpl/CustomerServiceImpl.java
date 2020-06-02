package com.demo.CustomerMS.serviceimpl;

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
		
		if(customerRepository.findByEmail(customer.getEmail())==null) 
		{
			return customerRepository.saveAndFlush(customer);
		}
		else 
		{
			logger.error("Customer with {}"+ customer.getEmail()+ " already exists in the system");
			throw new DuplicateResourceException("Customer with " + customer.getEmail() + " already exists in the system");
		}
		
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
	public Customer getById(Long id) {
		return customerRepository.findById(id).orElseThrow(()->
		{
			logger.error("Customer with id  "+ id +" is not found");
			return new NoResourceFoundException("Customer with id : "+ id + " is not found");
		});
	}

}
