package com.demo.EquipmentMS.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.EquipmentMS.entity.Equipment;
import com.demo.EquipmentMS.repository.IEquipmentRepository;
import com.demo.EquipmentMS.service.IEquipmentService;

@Service
public class EquipmentServiceImpl implements IEquipmentService{

	@Autowired
	private IEquipmentRepository equipmentRepository;
	
	@Override
	public Equipment add(Equipment t) {
		return null;
	}

	@Override
	public Equipment remove(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipment update(Equipment t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipment getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<String> getEquipmentNamesByCustomerId(Long custId)
	{
		List<String> equipmentList = new ArrayList<>();
		List<Equipment> equipments = equipmentRepository.findByCustId(custId);
		for(Equipment e : equipments) 
		{
			equipmentList.add(e.getEquipmentName());
		}
		
		return equipmentList;
	}
	
	public List<Equipment> getEquipments(Long custId)
	{
		return equipmentRepository.findByCustId(custId);
	}

}
