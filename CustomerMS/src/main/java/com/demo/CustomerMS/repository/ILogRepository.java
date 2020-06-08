package com.demo.CustomerMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.CustomerMS.kafka.entity.Record;

public interface ILogRepository extends JpaRepository<Record, Long> {

}
