package com.demo.EquipmentMS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.EquipmentMS.entity.Equipment;
import com.demo.EquipmentMS.repository.IEquipmentRepository;

@Component
public class DbInit {

	@Autowired
	private IEquipmentRepository equipmentRepository;
	
	@PostConstruct
	private void postconstruct() 
	{
		List<Equipment> equipmentList = new ArrayList<>();
		Equipment eq1 = new Equipment(1l, "Mouse",1l);
		Equipment eq2 = new Equipment(2l, "Keyboard",1l);
		Equipment eq3 = new Equipment(3l, "Apple Keyboard",2l);
		Equipment eq4 = new Equipment(4l, "guitar",1l);
		
		Equipment[] equipments = new Equipment[] {eq1, eq2, eq3 , eq4};
		equipmentList.addAll(Arrays.asList(equipments));
		equipmentRepository.saveAll(equipmentList);

		
	}
	
}
