package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import steps.Base;
import steps.TestFunctions;

public class T1_CheckCartItems extends Base {
	
	TestFunctions functions = new TestFunctions();
	
	@Test(priority = 1)
	public void SelectStore() throws IOException, InterruptedException {
	//Disable invoice pop-up
	functions.clickOnWithXpath("/html/body/div[2]/div[2]/div/mat-dialog-container/div/div/sm-invoice-form-modal/div/div[2]/fe-button/button");
	//Click Teslimat y�ntemi belirle
	functions.clickOnWithXpath("//button[contains(@class,'delivery-options-search-bucket-wrapper')]");
	// Click Ma�azan alaca��m
	functions.clickOnWithXpath("//div[@class='delivery-options ng-star-inserted']//div//div[1]");
	// Select City
	functions.clickOnWithXpath("//div[@id='mat-select-value-1']");
	functions.clickOnWithXpath("//input[@role='search']");
	functions.sendKeys("//input[@role='search']", "�stanbul");
	functions.clickOnWithXpath("//span[@class='mdc-list-item__primary-text'][contains(text(),'�stanbul')]");
	// Select District
	functions.clickOnWithXpath("//div[@id='mat-select-value-3']");
	functions.clickOnWithXpath("//input[@role='search']");
	functions.sendKeys("//input[@role='search']", "Ata�ehir");
	functions.clickOnWithXpath("//span[@class='mdc-list-item__primary-text']");
	// Select Store
	functions.clickOnWithXpath("//div[@id='mat-select-value-5']");
	functions.clickOnWithXpath("//input[@role='search']");
	functions.sendKeys("//input[@role='search']", "Ata�ehir trendist mmm migros");
	functions.clickOnWithXpath("//span[@class='mdc-list-item__primary-text']");
	// Validate Store
	String StoreName = functions.getItemName("//body/sm-root/div[@class='grid sanalmarket']/sm-header[@class='ng-tns-c300-1 ng-star-inserted']/div[@id='header-wrapper']/div[@class='header-middle ng-tns-c300-1 ng-star-inserted']/sm-header-address-delivery-time[@class='ng-tns-c300-1 ng-tns-c299-2 ng-star-inserted']/button[@class='delivery-options-search-bucket-wrapper ng-tns-c299-2 ng-star-inserted']/div[@class='delivery-options-wrapper ng-tns-c299-2']/div[@class='delivery-options-inner ng-tns-c299-2 ng-star-inserted']/div[@class='two-column-wrapper ng-tns-c299-2']/div[@class='ng-tns-c299-2']/div[1]");
	functions.validationItems(StoreName, "ATA�EH�R TREND�ST MMM M�GROS");	
	}
	@Test(priority = 2)
	public void searchPeach() throws InterruptedException {
		
		// Search "�eftali"
		functions.clickOnWithXpath("//input[@id='product-search-combobox--trigger']");
		functions.sendKeys("//input[@id='product-search-combobox--trigger']","�eftali");
		functions.clickOnWithXpath("//div[@class='migros-search-right-button subtitle-2 ng-star-inserted']");
		// Validation Search Page (Note � = %C5%9E)
		functions.CheckURLforSearch("%C5%9Eeftali");
		
	}
	@Test(priority = 3)
	public void AddFirstItemToCart () throws InterruptedException {
		// Add FirstItem (Sm-list page[index] = item index in list)
		functions.clickOnWithXpath("//sm-list-page-item[1]//mat-card[1]//div[2]//sm-product-actions[1]//fa-icon[1]//*[name()='svg']");
		
	}
	@Test(priority = 4)
	public void CheckCartPage() throws InterruptedException {
	
		// Get ItemName from search page
		String ExpectedAddedItem = functions.getItemName("//sm-list-page-item[1]//mat-card[1]//a[@class = 'mat-caption text-color-black product-name']");
		// Go Cart detail page
		functions.clickOnWithXpath("//div[@class='toggle-layer ng-tns-c294-3']");
		functions.clickOnWithXpath("//button[normalize-space()='Sepete Git']");
		// Get ItemName from CartDetailPage
		String ActualAddedItem = functions.getItemName("//div[@class = 'cart-page-item'][1]//a[@class='subtitle-2 text-color-black']");
		functions.validationItems(ActualAddedItem, ExpectedAddedItem);
		
	}
	
	
}
