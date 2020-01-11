package com.shopQAPOM.auto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopQAPOM.auto.base.TestBase;

public class MyAccountPage extends TestBase{

	//Page Factory - Object Repository
	@FindBy(id="username")
	WebElement weUserName;
	
	@FindBy(id="password")
	WebElement wePassword;
	
	@FindBy(name="login")
	WebElement weLoginBtn;
	
	//Page Constructor

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions
	public String getMyAccountPageTitle() {
		return driver.getTitle();
	}
	
	public void loginUser(String inpUserName, String inpPassword) {
		weUserName.sendKeys(inpUserName);
		wePassword.sendKeys(inpPassword);
		weLoginBtn.click();
	}

}