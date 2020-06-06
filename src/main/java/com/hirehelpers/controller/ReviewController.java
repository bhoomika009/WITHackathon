package com.hirehelpers.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hirehelpers.model.entity.Review;
import com.hirehelpers.service.ReviewService;

@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @RequestMapping(value = "/helper/reviews/get", method = RequestMethod.GET)
    public List<Review> getAllReviews() {

        return reviewService.getReviews();

    }


   @RequestMapping(value = "/helper/reviews/save", method = RequestMethod.POST)
    public ResponseEntity saveReviews(@RequestBody Review review) {
	   
        reviewService.save(review);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}


