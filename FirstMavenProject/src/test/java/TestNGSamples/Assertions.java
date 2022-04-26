package TestNGSamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assertions {
	
	WebDriver driver;
	
	@BeforeClass
	public void before() {
		System.setProperty("webdriver.chrome.driver","D:\\Selenium Driver Softwares\\chromedriver_win32-Unzip\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://qalegend.com/restaurant/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	
  @Test
  public void verifyTheUsernameAfterSuccessfulLogin() {
	  WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
	  username.sendKeys("admin");
	  WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
	  password.sendKeys("password");
	  WebElement loginButton = driver.findElement(By.xpath("//input[@name='submit']"));
	  loginButton.click();
	  WebElement name = driver.findElement(By.xpath("//span[contains(text(),'admin Doe')]"));  //  (//span[normalize-space(text()='admin Doe')])[21]
	  String expectedName = "  admin Doe";
	  String actualName = name.getText();
	  Assert.assertEquals(actualName, expectedName);
	  
  }
  
  @AfterClass
  public void after() {
	  driver.quit();
  }
  
}
