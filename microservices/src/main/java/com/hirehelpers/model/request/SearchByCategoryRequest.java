package com.hirehelpers.model.request;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SearchByCategoryRequest {
	
	private List<String> categories;
	
	public SearchByCategoryRequest(){
		
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	
	

	
}
