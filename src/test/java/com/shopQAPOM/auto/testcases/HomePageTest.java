package com.shopQAPOM.auto.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopQAPOM.auto.base.TestBase;
import com.shopQAPOM.auto.pages.HomePage;
import com.shopQAPOM.auto.pages.MyAccountPage;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	MyAccountPage myaccountPage;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}
	
	@Test (priority=1)
	public void homePageTitleTest() {
		Assert.assertEquals(homePage.getHomePageTitle(),"ToolsQA Demo Site – ToolsQA – Demo E-Commerce Site");
		
	}
	
	@Test (priority=2)
	public void LoginButtonTest() {
		myaccountPage = homePage.gotoMyAccountPage();
		String actualTitle = myaccountPage.getMyAccountPageTitle();
		Assert.assertEquals(actualTitle,"My Account – ToolsQA Demo Site");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}