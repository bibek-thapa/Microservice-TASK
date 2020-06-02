package com.demo.ProfileService.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {

	CustomerDTO customer;
	List<EquipmentDTO> equimpment;
}
