package openPage;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import browsers.Browsers;

public class OpenPageDetails {
	
	WebDriver driver;
	
	@Test
	public void OpenPage(){
		
		/*driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.owners.com/");*/
		
		driver= new Browsers().getDriver();
		driver.findElement(By.xpath("//*[@class='header-logo']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,700)");
		
		
		
		
	}

}
