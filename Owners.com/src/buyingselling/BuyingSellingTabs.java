package buyingselling;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import browsers.Browsers;

public class BuyingSellingTabs {

	WebDriver driver;
	

	@BeforeClass
	public void OpenBrowser() {
		
		System.out.println("Browser Opened");
	}

	@Test
	public void OpenApp() {
		//driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		//driver.get("https://www.owners.com/");
		/*if(driver == null){
			driver = bws.browserOpenig();
			
		}*/
		this.driver= new Browsers().getDriver();
	 	System.out.println("Application started");
		

	}

	@Test(dependsOnMethods = "OpenApp")
	public void ClickBuying() {

		String str = null, str1 = null, str2 = null, str3 = null;
		str = "If you bought this home with Owners.com® for $785,000,\nyou could get\n$11,775 back.";
		str1 = "If you bought this home with Owners.com® for $375,000,\nyou could get\n$5,625 back.";
		str2 = "If you bought this home with Owners.com® for $500,000,\nyou could get\n$7,500 back.";
		str3 = "If you bought this home with Owners.com® for $225,000,\nyou could get\n$3,375 back.";

		driver.findElement(By.xpath("//h1[text()='Buying']")).click();
		System.out.println("Clicked Buying");

		

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean status = driver
				.findElement(By.xpath("//section[(contains(@class,'hero')) and @data-current-action='buying']"))
				.isDisplayed();
		
		String exp = driver.findElement(By.xpath("//p[@class='buying']")).getText();
		System.out.println(exp);
		if (status = true && exp.equals(str)) {

			System.out.println(exp);
		} else if (status = true && exp.equals(str1)) {

			System.out.println(exp);
		} else if (status = true && exp.equals(str2)) {
			System.out.println(exp);

		} else if (status = true && exp.equals(str3)) {
			System.out.println(exp);

		}else {
			AssertJUnit.assertEquals(12, 13);;
		}

	}

	@Test(dependsOnMethods = "OpenApp")
	public void ClickSelling() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//h1[text()='Selling']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Clicked Selling");

		String str, str1, str2, str3;
		str = "If you sold this home with Owners.com® for $785,000,\nyou could save up to $23,155.";
		str1 = "If you sold this home with Owners.com® for $375,000,\nyou could save up to $10,855.";
		str2 = "If you sold this home with Owners.com® for $500,000,\nyou could save up to $14,605.";
		str3 = "If you sold this home with Owners.com® for $225,000,\nyou could save up to $6,355.";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean status = driver
				.findElement(By.xpath("//section[(contains(@class,'hero')) and @data-current-action='selling']"))
				.isDisplayed();
		String exp = driver.findElement(By.xpath("//p[@class='selling']")).getText();
		System.out.println(exp);
		if (status = true && exp.equals(str)) {

			System.out.println(exp);
		} else if (status = true && exp.equals(str1)) {

			System.out.println(exp);
		} else if (status = true && exp.equals(str2)) {
			System.out.println(exp);

		} else if (status = true && exp.equals(str3)) {
			System.out.println(exp);

		}else {
			AssertJUnit.assertEquals(12, 13);
		}

		/*
		 * @AfterClass public void BrowserClose(){ driver.quit(); }
		 */

	}
}
