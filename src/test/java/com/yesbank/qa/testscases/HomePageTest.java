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

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage=new LoginPage(driver);
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=new HomePage(driver);
	}
	
	/*@Test
	public void verifyHomePageTitlePage() {

		String homePageTitle=homePage.verifyHomePageTitle();
		System.out.println(homePageTitle);
		Assert.assertEquals(homePageTitle, "OrangeHRM","HomePage  does not match");
	}*/
	
	@Test(priority=1)
	public void verifyUserNameTest() {
		homePage.clickAdminTab();
		Assert.assertTrue(homePage.verifyUsernameLabel());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		Reporter.log("Close Browser");
	}

}
