package com.shopQAPOM.auto.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import com.digiCRMTest.autoqa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	//Constructor for Parent class
	// Test Base Class is a parent for all classes
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/shopQAPOM/auto/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			String path = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("Firefox")) {
		 	  System.setProperty("webdriver.gecko.driver", "/Selenium-3.141.59/geckodriver.exe");
	          driver = new FirefoxDriver();
		}
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        
        driver.get(prop.getProperty("url"));
	}

}