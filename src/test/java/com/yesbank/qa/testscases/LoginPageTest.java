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

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

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

	@Severity(SeverityLevel.NORMAL)	
	@Test(priority=1, description="Verify login page Title")
	@Description("Verify login with page Title........")
	@Epic("EP001")
	@Feature("Feature2: Login page Title")
	@Story("Story:Valid login page Title")
	@Step("Verify login page Title")
	public void loginPageTitleTest()
	{
		String title= loginPage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "OrangeHRM");
	}


	@Severity(SeverityLevel.BLOCKER)	
	@Test(priority=2, description="Verify login")
	@Description("Verify login with Valid Credentials........")
	@Epic("EP002")
	@Feature("Feature2: Login")
	@Story("Story:Valid login")
	@Step("Verify login")
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
