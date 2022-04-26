package TestNGSamples;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class LoginCRM {
	
	WebDriver driver;
	
  @Test
  public void verifyTheSuccessfulLoginAndLoout() throws InterruptedException {
	  
	  WebElement username = driver.findElement(By.id("lgn-mail"));
	  username.sendKeys("admin");
	  WebElement password = driver.findElement(By.id("lgn-pass"));
	  password.sendKeys("12345678");
	  
	  WebElement addingText = driver.findElement(By.xpath("//*[text()='What is 7 Plus 10 =']"));
	  System.out.println(addingText.isDisplayed());
	  
	  
//	  WebElement answer = driver.findElement(By.id("lgn-bot"));
//	  answer.sendKeys("12");
//	  Thread.sleep(3000);
//	  WebElement LoginButton = driver.findElement(By.id("lgn-submit"));
//	  LoginButton.click();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  	System.setProperty("webdriver.chrome.driver","D:\\Selenium Driver Softwares\\chromedriver_win32-Unzip\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://qalegend.com/crm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  //driver.quit();
  }

}
