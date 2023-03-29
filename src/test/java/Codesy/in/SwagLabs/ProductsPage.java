package Codesy.in.SwagLabs;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testCaseClasses.BaseTest;

public class ProductsPage {
	
	WebDriver driver;		
	public ProductsPage(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	//Initialization of WebElements
	@FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-backpack']")
	WebElement sauceLabsBackpack;
	
	@FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-onesie']")
	WebElement sauceLabsOnesie; 
	
	@FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-bike-light']")
	WebElement sauceLabsBikeLight; 
	
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement shoppingCartBadge;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement shoppingCartLink;
	
	//Menu Button
	@FindBy(xpath = "//*[@id='react-burger-menu-btn']")
	WebElement menuButton;
	
	//About
	@FindBy(xpath = "//*[@id='about_sidebar_link']")
	WebElement aboutLink;
	
	//Logout
	@FindBy(xpath = "//*[@id='logout_sidebar_link']")
	WebElement logoutLink;
	
		
	//Action Method
	public void addProductsToCart() {
		sauceLabsBackpack.click();
		sauceLabsOnesie.click();
		sauceLabsBikeLight.click();			
		
	}
	
	public void verifyShoppingCartBadgeValue(String expectedValue) {
		String actualBadgeVal = shoppingCartBadge.getText();
		
		Assert.assertEquals(actualBadgeVal, expectedValue, "Shopping Cart Badge value is NOT Matching.");
//		if(expectedValue.equals(actualBadgeVal)) {
//			System.out.println("Shopping Cart Badge value is Matching. Value is " + actualBadgeVal);
//		}
//		else {
//			System.out.println("Shopping Cart Badge value is NOT Matching. Expected Value is " + expectedValue + " but Actual Value on UI is: " + actualBadgeVal);
//		}
	}
	
	public void goToShoppingCart() {
		shoppingCartLink.click();
	}
	
	public void goToAbout() {
		menuButton.click();
		
		//ExplicitWait
		//BaseTest baseT = new BaseTest();
		//baseT.waitTillVisibilityOfElement(aboutLink, 5);
		
		aboutLink.click();
	}
	
	public void logOut() {
		menuButton.click();
		
		//ExplicitWait
		//BaseTest baseT = new BaseTest();
		//baseT.waitTillVisibilityOfElement(logoutLink, 5);
		
		logoutLink.click();
	}

}
