package com.hirehelpers.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.hirehelpers.model.entity.Helper;

public interface HelperRepository extends JpaRepository<Helper, Integer> {

	List<Helper> findAll();
   
   @Query(
		   value = "SELECT * FROM helper h WHERE h.category IN (:categories)", 
		   nativeQuery = true)
   List<Helper> findByCategory(@Param("categories") List<String> categories);
   
   List<Helper> findByHireById(@Param("hireById") int hireById);
   
	
	List<Helper> findById(int id);

}
