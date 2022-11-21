package com.mmt.stepdefinitions;

import static com.mmt.support.FrameworkConstants.getHomepage;

import java.sql.Time;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import com.mmt.config.utils.ConfigProperties;
import com.mmt.config.utils.PropertyUtils;
import com.mmt.drivers.DriverManager;
import com.mmt.drivers.Drivers;
import com.mmt.pages.HomePage;
import com.mmt.pages.PageManager;
import com.mmt.testdata.excel.ExcelUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDefinition_HomePage {

	HomePage homePage;
	
	
	@Before
	public void setup() {
		Drivers.initializeDriver();
	}
	
	@After
	public void tearDown() {		
		Drivers.quitDrivers();
	}
	
	//The URL of MakeMyTrip website is retrieved from the properties file
	@Given("I navigate to the MakemyTrip Website")
	public void i_navigate_to() throws InterruptedException {
		String makemytripUrl = PropertyUtils.get(ConfigProperties.URL);
	    DriverManager.getDriver().get(makemytripUrl);
	}

	@When("I click on flights")
	public void i_click_on_flights() throws InterruptedException {
	    homePage = PageManager.getInstance().getHomePage();
	    //homePage.closePopup();
	    Thread.sleep(2000);
	    homePage.selectFlight();
	    Thread.sleep(5000);
	    
	}	
}
