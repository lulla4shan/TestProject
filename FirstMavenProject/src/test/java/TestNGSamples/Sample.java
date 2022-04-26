package TestNGSamples;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Sample {
	
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver","D:\\Selenium Driver Softwares\\chromedriver_win32-Unzip\\chromedriver.exe");
		driver = new ChromeDriver();

	}
	
	
	@BeforeMethod
	  public void beforeMethod() {
		  
		  		driver.get("https://resume.naukri.com/resume-quality-score");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  
	  }
		
  @Test
  public void fileUpload() throws InterruptedException, AWTException {
	  
	  WebElement browse = driver.findElement(By.xpath("//span[text()='Browse']"));
		browse.click();
		Thread.sleep(3000);

		// creating object of Robot class
		Robot rb = new Robot();

		// Store the File path to the StringSelection class
		StringSelection filePath = new StringSelection("C:\\Users\\dell\\Desktop\\Obsqura SE Notes\\Scrolling PDF.pdf");

		//Copy above path to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		// press Contol+V for pasting
		rb.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(4000);
		rb.keyPress(KeyEvent.VK_V);

		// release Contol+V for pasting
		rb.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(4000);
		rb.keyRelease(KeyEvent.VK_V);

		// for pressing and releasing Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		rb.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("file uploaded..");
	  
  }
  
 
  @AfterMethod
  public void afterMethod() {
	   
	driver.close();
  }
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
