package com.demo.EquipmentMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.demo.EquipmentMS.dto.CustomerDTO;
import com.demo.EquipmentMS.entity.Equipment;

@Repository
public interface IEquipmentRepository extends JpaRepository<Equipment, Long> {
	
	public List<Equipment> findByCustId(Long id);

}
