package Codesy.in.SwagLabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	WebDriver driver;		
	public CheckoutPage(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	//Initialization of WebElements
	
	@FindBy(xpath = "//*[@id='first-name']")
	WebElement firstName;
	
	@FindBy(xpath = "//*[@id='last-name']")
	WebElement lastName;
	
	@FindBy(xpath = "//*[@id='postal-code']")
	WebElement postalCode;
	
	@FindBy(xpath = "//*[@id='continue']")
	WebElement continueBtn;
	
	
	//Action Method
	public void fillCheckoutInfo(String fName, String lName, String postalC) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		postalCode.sendKeys(postalC);
		
		continueBtn.click();
	}

}
