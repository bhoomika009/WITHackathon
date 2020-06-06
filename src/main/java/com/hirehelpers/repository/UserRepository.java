package com.hirehelpers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hirehelpers.model.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select u from User u where u.userId = :userId and u.userPwd = :userPwd")
    List<User> findByUserIdPwd(@Param("userId")String userId, @Param("userPwd")String userPwd);	
	
	List<User> findByUserId(String user);
}
