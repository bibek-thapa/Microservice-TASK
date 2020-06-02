package com.demo.ProfileService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDTO {
	
	private Long id;

	private String equipmentName;
	
	private Long custId;

}
