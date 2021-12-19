package steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class Base {
	
	
	public static WebDriver driver;

	
	@BeforeSuite
	public void openBrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver", "./Data/chromedriver.exe");
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.migros.com.tr/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@AfterSuite
	public void closeBrowser() throws IOException {
		
		
		driver.close();
		
		
	}
	
}
