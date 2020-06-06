package com.hirehelpers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hirehelpers.model.entity.Agent;
import com.hirehelpers.model.entity.User;


public interface AgentRepository extends JpaRepository<Agent, Integer> {
	
	@Query("select a from Agent a where a.agentId = :agentId and a.agentPwd = :agentPwd")
    List<Agent> findByAgentIdPwd(@Param("agentId")String agentId, @Param("agentPwd")String agentPwd);	
	
	List<Agent> findByAgentId(String agent);
}
