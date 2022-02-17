package com.yesbank.qa.testscases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yesbank.qa.base.TestBase;
import com.yesbank.qa.pages.HomePage;
import com.yesbank.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage=new LoginPage(driver);
	}

	public void loginPageTitleTest()
	{
		String title= loginPage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "title");
	}
	
	@Test
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("Login Succsessfully");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		Reporter.log("Close Browser");
	}

}
