package com.yesbank.qa.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.yesbank.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(linkText ="Admin")
	WebElement adminTab;

	@FindBy(linkText ="PIM")
	WebElement pimTab;

	@FindBy(linkText ="Leave")
	WebElement leaveTAB;

	@FindBy(linkText ="Time")
	WebElement timeTAB;

	@FindBy(linkText ="Recruitment")
	WebElement recruitmentTAB;

	@FindBy(linkText ="My Info")
	WebElement myInfoTAB;

	@FindBy(linkText ="Performance")
	WebElement performanceTAB;

	@FindBy(linkText ="Dashboard")
	WebElement DashboardTAB;

	@FindBy(linkText ="Directory")
	WebElement directoryTAB;

	@FindBy(linkText ="Maintenance")
	WebElement maintenanceTAB;

	@FindBy(linkText ="Buzz")
	WebElement buzzTAB;

	@FindBy(xpath ="//label[contains(text(),'Username')]")
	WebElement usernameLabel;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickleaveTAB()
	{
		leaveTAB.click();
		Reporter.log("Click the leave Tab ");
	}

	public void clickAdminTab()
	{
		adminTab.click();
		Reporter.log("Click the Admin Tab ");
	}

	public void clickTimeTAB()
	{
		timeTAB.click();
		Reporter.log("Click the time Tab ");
	}

	public void clickRecruitmentTAB()
	{
		recruitmentTAB.click();
		Reporter.log("Click the recruitment Tab ");
	}

	public void clickPerformanceTAB()
	{
		performanceTAB.click();
		Reporter.log("Click the performance Tab ");
	}

	public void clickMyInfoTAB()
	{
		myInfoTAB.click();
		Reporter.log("Click the myInfo Tab ");
	}

	public void clickPimTab()
	{
		pimTab.click();
		Reporter.log("Click the pim Tab ");
	}

	public void clickDashboardTAB()
	{
		DashboardTAB.click();
		Reporter.log("Click the Dashboard Tab ");
	}

	public void clickMaintenanceTAB()
	{
		maintenanceTAB.click();
		Reporter.log("Click the maintenance Tab ");
	}

	public void clickDirectoryTAB()
	{
		directoryTAB.click();
		Reporter.log("Click the directory Tab ");
	}

	public void clickbuzzTAB()
	{
		buzzTAB.click();
		Reporter.log("Click the buzz Tab ");
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUsernameLabel() {
		return usernameLabel.isDisplayed();
	}


}
