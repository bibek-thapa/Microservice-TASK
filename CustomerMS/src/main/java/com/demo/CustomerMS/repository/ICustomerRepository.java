package com.demo.CustomerMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.CustomerMS.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>{

	public Customer findByEmail(String email);
}
