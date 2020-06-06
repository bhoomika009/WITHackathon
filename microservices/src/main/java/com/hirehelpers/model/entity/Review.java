package com.hirehelpers.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Review {


    @Id
    @GeneratedValue
    private int id;
    private String reviewedById;
    private String comments;
    private int rating;
    private int helperId;
    private Date reviewedOn;

    public Review() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getHelperId() {
        return helperId;
    }

    public void setHelperId(int helperId) {
        this.helperId = helperId;
    }


    
    public String getReviewedById() {
		return reviewedById;
	}

	public void setReviewedById(String reviewedById) {
		this.reviewedById = reviewedById;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getReviewdOn() {
		return reviewedOn;
	}

	public void setReviewdOn(Date reviewdOn) {
		this.reviewedOn = reviewedOn;
	}

/*	public Review(int id, String hirer, String revAgency, String revHelper, Date revAddedDate, int rating, int helperId, int hirerId) {
        this.id = id;
        this.hirer = hirer;
        this.revAgency = revAgency;
        this.revHelper = revHelper;
        this.revAddedDate = revAddedDate;
        this.rating = rating;
        this.helperId = helperId;
        this.hirerId = hirerId;
    }*/
}
