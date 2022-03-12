package com.yesbank.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.yesbank.qa.base.TestBase;

import io.qameta.allure.Step;

public class LoginPage extends TestBase {

	//PageFactory (Object repository) collection of WebElement
	@FindBy(id="txtUsername")
	WebElement username;

	@FindBy(id="txtPassword")
	WebElement password;

	@FindBy(id="btnLogin")
	WebElement loginBtn;

	//Initialization Page objects
	public LoginPage(WebDriver driver) throws IOException {     
		PageFactory.initElements(driver, this);
	}

	//Action
	@Step("getting Login Page Title Step....")
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}


	@Step("Login with username: {0} and password: {1} Step....")
	public HomePage login(String uname,String pass) {

		Reporter.log("Enter the Username :" +uname);
		Reporter.log("Enter the Password :" +pass);

		username.sendKeys(uname);
		password.sendKeys(pass);
		Reporter.log("Click the Login button");

		loginBtn.click();
		Reporter.log("Login Successfully");
		return new HomePage(driver);
	}


}
