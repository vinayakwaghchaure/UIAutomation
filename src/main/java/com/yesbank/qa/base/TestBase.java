package com.yesbank.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import com.yesbank.qa.util.TestUtil;
import com.yesbank.qa.util.WebEventListener;

public class TestBase {
	public static  WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eventFiringWebDriver;
	public static WebEventListener eventListener;


	public TestBase() {
		try {
			prop=new Properties();
			String path=System.getProperty("user.dir")+"/src/main/java/com/yesbank/qa/config/config.properties";
			FileInputStream ip=new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static void initialization() {
		String browserName=	prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D://JavaPractice/UIYesbank/Drivers/CromeDriver/chromedriver.exe");
			driver=new ChromeDriver();
			Reporter.log("Lounch the browser");

		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "");
			driver=new FirefoxDriver();
		}

		eventFiringWebDriver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		eventFiringWebDriver.register(eventListener);
		driver=eventFiringWebDriver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		System.out.println(prop.getProperty("url"));
	}

}
