
package com.demo.EquipmentMS.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.EquipmentMS.entity.Equipment;
import com.demo.EquipmentMS.serviceimpl.EquipmentServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@RestController
@RequestMapping("/api/equipments")
public class EquipmentController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EquipmentServiceImpl equipmentService;
	
	@HystrixCommand(fallbackMethod = "fallBackForEquipmentByCustomerID")
	@GetMapping("/{customerId}")
	public List<String> getAllequipmentNameByCustomerId(@PathVariable("customerId")Long customerId)
	{
		logger.info("Getting the all equipment names by customer with id{}", customerId);
		System.out.println("In Profile");
		return equipmentService.getEquipmentNamesByCustomerId(customerId);
	}
	
	
	public List<String> fallBackForEquipmentByCustomerID(Long customerId) 
	{
		System.out.println("In fallback");
		return new ArrayList<String>();
	}
	
	@GetMapping("/all/{customerId}")
	public List<Equipment> getAllequipmentByCustomerId(@PathVariable("customerId")Long customerId)
	{
		return equipmentService.getEquipments(customerId);
	}

}
