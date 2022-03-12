package com.yesbank.qa.testscases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.yesbank.qa.base.TestBase;
import com.yesbank.qa.pages.HomePage;
import com.yesbank.qa.pages.LoginPage;
import com.yesbank.qa.pages.UserManagementPage;
import com.yesbank.qa.util.TestUtil;

public class TestLog4j extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	UserManagementPage userManagementPage;
	String seetName="User";
	Logger log=Logger.getLogger(TestLog4j.class);
	public TestLog4j() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		log.info("Lunching the browser");
		loginPage=new LoginPage(driver);
		log.info("login into the page");
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("login the page successfully");
	}


	@DataProvider 
	public Object[][] getTestData()
	{
		Object data[][]=TestUtil.getTestData(seetName);
		return data;
	}


	@Test(priority=1, dataProvider="getTestData")
	public void validateNewUse(String EmpName,String userName,String pass,String confirmpass) throws IOException
	{
		homePage=new HomePage(driver);
		homePage.clickAdminTab();
		log.info("click Admin Tab");
		Assert.assertTrue(homePage.verifyUsernameLabel());
		userManagementPage=new UserManagementPage(driver);
		System.out.println(EmpName +" "+userName+ " "+pass+" "+confirmpass);
		userManagementPage.addUser(EmpName,userName,pass,confirmpass);
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
		Reporter.log("Close Browser");
		log.info("close the Browser");
	}


}
