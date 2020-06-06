package com.hirehelpers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hirehelpers.model.entity.Review;



@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {



}
