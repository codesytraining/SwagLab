package Codesy.in.SwagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderOverviewPage {
	
	WebDriver driver;		
	public OrderOverviewPage(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	//Initialization of WebElements	
	@FindBy(xpath = "//div[@class='summary_value_label'][1]")
	WebElement paymentInfoText;
	
	@FindBy(xpath = "//div[@class='summary_value_label'][2]")
	WebElement shippingInfoText;
	
	@FindBy(xpath = "//*[@id='finish']")
	WebElement finishBtn;
	
	
	//Action Method
	public String getPaymentInfoDetails() {
		String paymentInfo;
		paymentInfo = "";
		
		paymentInfo = paymentInfoText.getText();
		paymentInfo = paymentInfo + ";" + shippingInfoText.getText();
		
		finishBtn.click();
		return paymentInfo;
	}

}
