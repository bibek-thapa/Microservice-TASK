package com.demo.EquipmentMS.kafka.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
	
	String time;
	String application_name;
	String trace_id;
	String span_id;
	String parentSpanId;
	String request;
	String response;
	String level;
	
	
	
}
