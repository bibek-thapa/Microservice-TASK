package com.demo.ProfileService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.ProfileService.kafka.entity.Record;

public interface ILogRepository extends JpaRepository<Record, Long> {

}
