package com.demo.ProfileService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.ProfileService.dto.CustomerDTO;
import com.demo.ProfileService.dto.EquipmentDTO;
import com.demo.ProfileService.dto.ProfileDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
@RequestMapping("/api/profiles/")
public class ProfileController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@HystrixCommand(fallbackMethod="getProfileFallback")
	@GetMapping("{customerId}")
	public ProfileDTO getProfile(@PathVariable("customerId") Long customerId) 
	{
		
		ProfileDTO profileDTO = new ProfileDTO();
		RestTemplate template = new RestTemplate();
		
		
		CustomerDTO customerDTO = template.getForObject("http://localhost:8082/api/customers/"+ customerId, CustomerDTO.class);
		profileDTO.setCustomer(customerDTO);

		List<EquipmentDTO> equipmentDTO = (List<EquipmentDTO>)template.getForObject("http://localhost:8083/api/equipments/"+ customerId, List.class);
		profileDTO.setEquimpment(equipmentDTO);
		
		return profileDTO;
	}
	
	
	public ProfileDTO getProfileFallback(Long customerId) 
	{
		logger.info("In fallback of Profile controller method");
		return new ProfileDTO();
	}

}
