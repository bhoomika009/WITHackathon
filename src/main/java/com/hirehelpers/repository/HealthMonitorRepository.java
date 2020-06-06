package com.hirehelpers.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hirehelpers.model.entity.HealthMonitor;

public interface HealthMonitorRepository extends JpaRepository<HealthMonitor, Integer> {
   List<HealthMonitor> findAll();
   
   List<HealthMonitor> findByHelperId(int helperId);
   
   @Transactional
   @Modifying
   @Query(value = "UPDATE healthmonitor h set h.temperature = :temperature AND h.pulse_rate = :pulseRate  where h.helper_id = :helperId",
           nativeQuery = true)
void updateHealth(@Param("temperature") String temperature,  @Param("pulseRate")  String pulseRate,
		@Param("helperId")  int helperId);
   
}
	