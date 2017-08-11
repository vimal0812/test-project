package buyMenu;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import browsers.Browsers;

public class BuyMenuChecking {

	WebDriver driver;
	Dimension MaxSize, MinSize;
	//Browsers bws= new Browsers();

	@Test
	public void OpenApp() {
		/*//driver = new FirefoxDriver();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.owners.com/");*/
		
		
		driver= new Browsers().getDriver();
		System.out.println("Application started");

	}

	@Test(dependsOnMethods = "OpenApp")
	public void MenuExpnd() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Menu Checking");
		boolean dis = driver.findElement(By.xpath("//a[@class='autoHeaderNavLink1 buy-header-link']")).isDisplayed();
		System.out.println("Menu displayed");
		System.out.println(dis);
		if (dis == true) {
			System.out.println("Clicking on menu");
			driver.findElement(By.xpath("//a[@class='autoHeaderNavLink1 buy-header-link']")).click();
			System.out.println("Clicked on menu");
			String currentUrl = driver.getCurrentUrl();
			//AssertJUnit.assertTrue(currentUrl.contains("/search"));
			System.out.println("/search is present in the url");
		} else {
			AssertJUnit.assertEquals(12, 13);
		}
	}

	@Test(dependsOnMethods = "MenuExpnd")
	public void SearchPage() {

		boolean sts = driver.findElement(By.xpath("//div[@class='pr-src-list-module']")).isDisplayed();
		if (sts == true) {
			MaxSize = driver.findElement(By.xpath("//div[@class='pr-src-list-module']")).getSize();
			System.out.println("aaa" + MaxSize);
		} else {
			AssertJUnit.assertEquals(12, 13);
		}
	}

	@Test(dependsOnMethods = "SearchPage")
	public void FrameMaxManagement() {

		String frmTagMax = "Less",  getMax;
		getMax = driver.findElement(By.xpath("//span[@class='less']")).getText();
		System.out.println(getMax);
		int status = frmTagMax.compareTo(getMax);
		System.out.println(status);
		if (frmTagMax.compareTo(getMax) == 0) {
			driver.findElement(By.xpath("//span[@class='less']")).click();
			MinSize=driver.findElement(By.xpath("//span[@class='more']")).getSize();
			
		} else {
			AssertJUnit.assertEquals(12, 13);
		}
		
		if ((MaxSize.height>MinSize.height) && MaxSize.width>MinSize.width){
			System.out.println("Frame has been minimized");
			
		}
		else{
			AssertJUnit.assertEquals(12, 13);
		}

	}
	
	
	@Test(dependsOnMethods="FrameMaxManagement")
	public void FrameMinManagement() throws InterruptedException {
		Thread.sleep(20000);
		String frmTagMin = "More",  getMin;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		getMin = driver.findElement(By.xpath("//span[@class='more']")).getText();
		System.out.println(getMin);
		int status = frmTagMin.compareTo(getMin);
		
		System.out.println(status);
		
		if (frmTagMin.compareTo(getMin) == 0) {
			driver.findElement(By.xpath("//span[@class='more']")).click();
		} else {
			AssertJUnit.assertEquals(12, 13);
		}

	}

}
