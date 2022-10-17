package com.mmt.testdata.excel.pojo;

import java.util.HashMap;

import lombok.Getter;


public class ReviewBookingPageData {

	private String reviewBooking;
	
	public String getReviewBooking() {
		return reviewBooking;
	}

	public void setReviewBooking(String reviewBooking) {
		this.reviewBooking = reviewBooking;
	}

	public ReviewBookingPageData(HashMap<String, String> data) {
		reviewBooking = data.get("ReviewBooking");
	}
}
