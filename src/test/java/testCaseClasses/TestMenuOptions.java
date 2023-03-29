package testCaseClasses;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Codesy.in.SwagLabs.AboutPage;
import Codesy.in.SwagLabs.LoginPage;
import Codesy.in.SwagLabs.ProductsPage;
import Codesy.in.SwagLabs.ReExecute;

public class TestMenuOptions extends BaseTest{
	
	@Test(retryAnalyzer=ReExecute.class ,dataProvider = "getDataForMenuTestCases")
	public void testAboutMenu(HashMap<String, String> inputData) throws IOException {
		
		WebDriver driver = launchApplication();	
		
		//Create Object of LoginPage class
		LoginPage login = new LoginPage(driver);
		login.loginToSwagApplication(inputData.get("UserName"), inputData.get("Password"));
		
		//Create Object of ProductsPage Class
		ProductsPage prPage = new ProductsPage(driver);
		prPage.goToAbout();
		
		//Create Object of AboutPage
		AboutPage abtPage = new AboutPage(driver);
		boolean result = abtPage.validateTitle(inputData.get("ExpectedTitle"));
//		if (result) {
//			System.out.println("Actual Title and Expected Title are Same!!");
//		}else {
//			System.out.println("Actual Title and Expected Title are NOT Same!!");
//		}
		Assert.assertTrue(result, "Actual Title and Expected Title are NOT Same!!");
		
	}
	
	@Test(dataProvider = "getDataForMenuTestCases")
	public void testLogOut(HashMap<String, String> inputData) throws IOException {
		WebDriver driver = launchApplication();	
		
		//Create Object of LoginPage class
		LoginPage login = new LoginPage(driver);
		login.loginToSwagApplication(inputData.get("UserName"),inputData.get("Password"));
		
		//Create Object of ProductsPage Class
		ProductsPage prPage = new ProductsPage(driver);
		prPage.logOut();
	}
	
	@DataProvider
	public Object[][] getDataForMenuTestCases() throws IOException {
		
//		Object[][] data = new Object[1][3];
//		data[0][0] = "standard_user";	//User Name
//		data[0][1] = "secret_sauce";	//Password
//		data[0][2] = "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing";		//Expected title
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map = readDataFromJSON("C:\\RohitData\\CODESY\\Selenium_Java\\Batch_18_Nov_2022\\TestingBatch\\SwagLabs\\src\\test\\java\\Resources\\menuTestData.json");
		
		return new Object[][] {{map}};		
	}

}
