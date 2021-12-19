package steps;

import static org.junit.Assert.assertEquals;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.lang.Thread;

public class TestFunctions extends Base {

	
	public void clickOnWithClassName(String className) throws InterruptedException {
		
		WebElement element = driver.findElement(By.className(className));
		element.click();
		Thread.sleep(2000);
	}
	
	public void clickOnWithXpath(String Xpath) throws InterruptedException {
		
		WebElement element = driver.findElement(By.xpath(Xpath));
		element.click();
		
		Thread.sleep(2000);
	}
	
	public void sendKeys(String Xpath, String Keys) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(Xpath));
		element.sendKeys(Keys);
		Thread.sleep(2000);
	}
	
	public String getItemName(String Xpath) {
		
		String ItemName = driver.findElement(By.xpath(Xpath)).getText();
		return ItemName;
	}
	
	
	public void validationItems(String actualResult,String ExpectedResult) {
		assertEquals(ExpectedResult+" Item is found." , ExpectedResult,actualResult);
	}
	
	public void CheckURLforSearch(String ExpectedResult) {
		int found = 0;
		if (driver.getCurrentUrl().contains(ExpectedResult)) {
			found = 1 ;
		}
		System.out.println(ExpectedResult);
		System.out.println(driver.getCurrentUrl());
		assertEquals(ExpectedResult +" Item is found",1, found);
	}
	
	
}
