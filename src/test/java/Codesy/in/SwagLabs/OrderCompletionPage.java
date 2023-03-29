package Codesy.in.SwagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderCompletionPage {
	
	WebDriver driver;		
	public OrderCompletionPage(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	//Initialization of WebElements	
	@FindBy(xpath = "//h2[@class='complete-header']")
	WebElement thankUText;
	
	@FindBy(xpath = "//*[@id='back-to-products']")
	WebElement backHomeBtn;
	
	
	//Action Method
	
	public void validateThankYouText(String expectedText) {
		String actualText = thankUText.getText();
		Assert.assertEquals(actualText.toLowerCase(), expectedText.toLowerCase());
//		if(actualText.equalsIgnoreCase(expectedText)) {
//			System.out.println(expectedText + " is displayed!!!");
//		}else {
//			System.out.println(expectedText + " is NOT displayed!!! Text displayed is : " + actualText);
//		}
		
	}
	
	public void goToHome() {
		backHomeBtn.click();		
	}

}
