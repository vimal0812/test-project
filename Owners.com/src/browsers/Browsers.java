package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;


@Test(priority=1,description="FireFox Open and go to the site")
public class Browsers {
	
	public static WebDriver driver;
	
public void browserOpenig(){
	
	System.setProperty("webdriver.ie.driver","D:\\Vimal\\SeleniumProjects\\Owners.com\\IEDriverServer.exe");
	//driver = new FirefoxDriver();
	driver = new ChromeDriver();
	//driver = new InternetExplorerDriver();
	driver.manage().window().maximize();
	driver.get("https://www.owners.com");
	

}


public WebDriver getDriver(){
	return driver;
}
	

}
