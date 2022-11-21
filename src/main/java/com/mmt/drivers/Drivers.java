package com.mmt.drivers;

import static com.mmt.support.FrameworkConstants.getChromedriver;
import static com.mmt.support.FrameworkConstants.getImplicitwait;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class Drivers {

	public static void initializeDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("enableVNC", true);
		capabilities.setCapability("enableVideo", false);
		if(Objects.isNull(DriverManager.getDriver())) {
			try{
				DriverManager.setDriver( new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
			}catch(MalformedURLException ex){			
				System.out.println("Incorrect url");
			}
		}
		implicitlyWait();
		maximizeBrowser();
	}
	
	public static void quitDrivers() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
	
	public static void implicitlyWait() {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(getImplicitwait(), TimeUnit.SECONDS);
	}
	
	public static void maximizeBrowser() {
		DriverManager.getDriver().manage().window().maximize();
	}	
}
