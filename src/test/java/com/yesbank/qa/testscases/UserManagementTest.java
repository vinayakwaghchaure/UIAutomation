package com.yesbank.qa.testscases;
import java.io.IOException;
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

public class UserManagementTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	UserManagementPage userManagementPage;
	
	String seetName="User";
	public UserManagementTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage=new LoginPage(driver);
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	/*@Test(priority=1)
	public void addUser() throws IOException {
		homePage=new HomePage(driver);
		homePage.clickAdminTab();
		Assert.assertTrue(homePage.verifyUsernameLabel());
		userManagementPage=new UserManagementPage(driver);
		userManagementPage.addUser();
		Reporter.log("Add User Successfully");
	}
*/
	
	
	
	
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
		Assert.assertTrue(homePage.verifyUsernameLabel());
		userManagementPage=new UserManagementPage(driver);
		
		System.out.println(EmpName +" "+userName+ " "+pass+" "+confirmpass);
		
		userManagementPage.addUser(EmpName,userName,pass,confirmpass);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		Reporter.log("Close Browser");
	}
	
}
