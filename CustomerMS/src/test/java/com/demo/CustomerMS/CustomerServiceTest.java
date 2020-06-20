//package com.demo.CustomerMS;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.awt.print.Book;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.demo.CustomerMS.entity.Customer;
//import com.demo.CustomerMS.repository.ICustomerRepository;
//import com.demo.CustomerMS.service.ICustomerService;
//import com.demo.CustomerMS.serviceimpl.CustomerServiceImpl;
//
//@RunWith(MockitoJUnitRunner.class)
//
//@SpringBootTest
//public class CustomerServiceTest {
//	
//	@Mock
//	ICustomerRepository customerRepository;
//	
//	
//	@InjectMocks
//	ICustomerService customerService = new CustomerServiceImpl();
//	
//	@BeforeEach
//	void setMockOutput() 
//	{
//		Customer customer1 = new Customer(3l, "Ramila", "Karki","ramilaa@gmail.com");
//		when(customerRepository.save(customer1)).thenReturn(customer1);
//		
//	}
//	
//	
//	
//	@Test
//	public void testSaveCustomer() 
//	{
//		Customer customer1 = new Customer(3l, "Ramila", "Karki","ramilaa@gmail.com");
//		System.out.println(customer1);
//		Customer customer2 = customerService.getById(3l);
//		assertEquals(customer1, customer2);
//		
//	}
//	
//	@Test
//	public void testGetById() throws Exception
//	{
//		Customer customer1 = new Customer(2l, "Ram", "Karki","ram@gmail.com");
//		when(customerRepository.getOne(2l)).thenReturn(customer1);
//		Customer customer2 = customerService.getById(2l);
//		assertEquals(customer1, customer2);
//		
//		
//	}
//	
//	
//}
