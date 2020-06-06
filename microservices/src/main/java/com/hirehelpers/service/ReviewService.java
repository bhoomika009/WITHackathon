package com.hirehelpers.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hirehelpers.model.entity.Review;


@Service @Component
public interface ReviewService {

    public void save (Review review);

    public List<Review> getReviews();


}
