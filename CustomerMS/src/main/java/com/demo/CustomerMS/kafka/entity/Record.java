package com.demo.CustomerMS.kafka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LOG_TBL")
public class Record {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	String time;
	
	@Column
	String application_name;
	
	@Column
	String trace_id;
	
	@Column
	String span_id;
	
	@Column
	String parentSpanId;
	
	@Column
	String request;
	
	@Column
	String response;
	
	@Column
	String level;
	
	
	
}
