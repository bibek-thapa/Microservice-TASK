package com.demo.ProfileService.contoller;



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

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	@GetMapping("/{customerId}")
	public ProfileDTO getProfileByCustomerId(@PathVariable("customerId")Long customerId) 
	{
		logger.info("Getting the profile for customer with id {}",customerId);
		
		RestTemplate restTemplate = new RestTemplate();
		ProfileDTO profileDTO = new ProfileDTO();
		List<EquipmentDTO> equipmentDTO = (List<EquipmentDTO>)restTemplate.getForObject("http://localhost:8082"+"/api/equipments/all/"+ customerId, List.class);
		
		profileDTO.setEquimpment(equipmentDTO);
		
		CustomerDTO customerDTO = restTemplate.getForObject("http://localhost:8083/api/customers/"+customerId , CustomerDTO.class);
		profileDTO.setCustomer(customerDTO);
		return profileDTO;
	}

}
