package com.shopQAPOM.auto.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopQAPOM.auto.base.TestBase;
import com.shopQAPOM.auto.pages.HomePage;
import com.shopQAPOM.auto.pages.MyAccountPage;


public class MyAccountPageTest extends TestBase{

	HomePage homePage;
	MyAccountPage myaccountPage;

	public MyAccountPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		myaccountPage = homePage.gotoMyAccountPage();
	}
	
	@Test
	public void validatePageTitle() {
		String actualTitle = myaccountPage.getMyAccountPageTitle();
		Assert.assertEquals(actualTitle,"My Account – ToolsQA Demo Site");
	}
	
	@Test
	public void signOnTest() {
		String inpUserName = prop.getProperty("username");
		String inpPassword = prop.getProperty("password");
		myaccountPage.loginUser(inpUserName, inpPassword);
		String newTitle = myaccountPage.getMyAccountPageTitle();
		Assert.assertEquals(newTitle,"My Account – ToolsQA Demo Site");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}