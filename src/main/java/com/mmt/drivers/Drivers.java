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
		//System.setProperty("webdriver.chrome.driver", getChromedriver());
		WebDriver driver;
		//WebDriverManager.chromedriver().driverVersion("106.0.5249.91").setup();
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless","--start-maximized","--ignore-certificate-errors", "--silent");
		ChromeOptions options = new ChromeOptions();
		options.setCapability("browserVersion", "107");
		options.addArguments("--headless", "--start-maximized","--ignore-certificate-errors" );
		if(Objects.isNull(DriverManager.getDriver())) {
			//DriverManager.setDriver(new ChromeDriver());
			DriverManager.setDriver( new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options));
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
