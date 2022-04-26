package TestNGSamples;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	
	WebDriver driver;
  
	@BeforeClass
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Driver Softwares\\chromedriver_win32-Unzip\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().window().maximize();
	}
	
	
	@Test(priority = 0)
  public void getTheCurrentURL() {
		System.out.println(driver.getCurrentUrl());
		
  }
	@Test(priority = 1)
	public void getTheTitle() {
		System.out.println(driver.getTitle());
		
	}
	@Test(priority = 2)
	public void getTheClass() {
		System.out.println(driver.getClass());
	}
	
	@AfterClass
	public void afterMethod() {
		driver.quit();
	}
}
