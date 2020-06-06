package com.hirehelpers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.hirehelpers.model.entity.Review;
import com.hirehelpers.repository.ReviewRepository;

@Component
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Async
    public void save (Review review){
     try {

         reviewRepository.save(review);
     }

     catch(Exception e){
        e.printStackTrace();
     }

    }

    public List<Review> getReviews(){

      return  reviewRepository.findAll();
    }

}
