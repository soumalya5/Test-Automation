package com.mmt.testdata.excel.pojo;

import java.util.HashMap;
import lombok.Getter;


public class HomePageData {

	private String departureDate;
	
	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public HomePageData(HashMap<String, String> data) {
		departureDate = data.get("DepartureDate");
	}
}
