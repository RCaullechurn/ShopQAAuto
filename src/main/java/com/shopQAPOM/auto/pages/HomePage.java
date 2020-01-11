package com.shopQAPOM.auto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopQAPOM.auto.base.TestBase;

public class HomePage extends TestBase{

	//Page Factory - Object Repository
	@FindBy(linkText="My Account")
	WebElement myaccountLink;
	
	@FindBy(linkText="Dismiss")
	WebElement dismissLink;
	
	
	
	
	// Constructor for Homepage
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public MyAccountPage gotoMyAccountPage() {
		if (dismissLink.isDisplayed())
		{
			dismissLink.click();
		}
		myaccountLink.click();
		return new MyAccountPage();
	}
	
}
