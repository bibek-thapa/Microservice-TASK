package com.demo.EquipmentMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.EquipmentMS.kafka.entity.Record;


public interface ILogRepository extends JpaRepository<Record, Long> {

}
