package Codesy.in.SwagLabs;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testCaseClasses.BaseTest;


public class ProductPurchaseTestCase extends BaseTest{
	
	@Test(dataProvider = "getDataForPurchaseProducts")
	public void purchaseProducts(HashMap<String, String> inputData) throws IOException {
		
		WebDriver driver = launchApplication();	
		
		//Create Object of LoginPage class
		LoginPage login = new LoginPage(driver);
		login.loginToSwagApplication(inputData.get("UserName"), inputData.get("Password"));
		
		//Add Products to Card
		ProductsPage prPage = new ProductsPage(driver);
		prPage.addProductsToCart();
		
		//Verify Shopping Cart Badge Value
		prPage.verifyShoppingCartBadgeValue(inputData.get("ExpectedProdCnt"));
		
		//Go to Shopping Cart
		prPage.goToShoppingCart();
		
		//Verify Cart Items
		ArrayList allProducts = new ArrayList();
		allProducts.add("Sauce Labs Backpack");
		allProducts.add("Sauce Labs Onesie");
		allProducts.add("Sauce Labs Bike Light");
		
		CartPage cartP = new CartPage(driver);
		cartP.verifyCartItems(allProducts);
		
		//Checkout Information
		cartP.checkout();
		
		CheckoutPage checkoutObj = new CheckoutPage(driver);
		checkoutObj.fillCheckoutInfo(inputData.get("FirstName"), inputData.get("LastName"), inputData.get("PostalCode"));
		
		//Payment Information
		OrderOverviewPage orderOverviewObj = new OrderOverviewPage(driver);
		String paymentDetails = orderOverviewObj.getPaymentInfoDetails();
		System.out.println(paymentDetails);
		
		//Order Completion
		//1.THANK YOU FOR YOUR ORDER
		//2. BackHome - Click
		OrderCompletionPage ordComplObj = new OrderCompletionPage(driver);
		ordComplObj.validateThankYouText(inputData.get("ThanksMsg"));
		ordComplObj.goToHome();	
		
	}
	
	
	@Test(dataProvider = "getDataForPurchaseProducts")
	public void loginTestCase(HashMap<String, String> inputData) throws IOException {
		
		WebDriver driver = launchApplication();	
		
		//Create Object of LoginPage class
		LoginPage login = new LoginPage(driver);
		login.loginToSwagApplication(inputData.get("UserName"), inputData.get("Password"));
	}
	
	
	//1. Hard Code - HashMap - Return two dimentional array
	//2. JASON -> Method which will read JSON data (String) and give it in HashMap
	//3. DataProvider -> Call method to read JASON -> Return HashMap to test case
	
	@DataProvider
	public Object[][] getDataForPurchaseProducts() throws IOException {
		
		//Create object of HashMap class -> Key - Value
		HashMap<String, String> map = new HashMap<String, String>();
		
		//Now put data into HashMap object
//		map.put("UserName", "standard_user");
//		map.put("Password", "secret_sauce");
//		map.put("ExpectedProdCnt", "3");
//		map.put("FirstName", "Codesy");
//		map.put("LastName", "Training");
//		map.put("PostalCode", "411000");
//		map.put("ThanksMsg", "THANK YOU FOR YOUR ORDER");
		
		map = readDataFromJSON("C:\\RohitData\\CODESY\\Selenium_Java\\Batch_18_Nov_2022\\TestingBatch\\SwagLabs\\src\\test\\java\\Resources\\inputData.json");
		
		//Return HashMap object in Two Dimentional Array
		return new Object[][] {{map}};
		
//		Object[][] data = new Object[1][7];
//		data[0][0] = "standard_user";	//User Name
//		data[0][1] = "secret_sauce";	//Password
//		data[0][2] = "3";		//Expected products count in cart
//		data[0][3] = "Codesy";	//First Name in Checkout
//		data[0][4] = "Training";	//Last Name in Checkout
//		data[0][5] = "411000";	//Postal COde in Checkout
//		data[0][6] = "THANK YOU FOR YOUR ORDER";	//Thank You Message
//		
//		return data;	
		
		
	}

	
	
	
}