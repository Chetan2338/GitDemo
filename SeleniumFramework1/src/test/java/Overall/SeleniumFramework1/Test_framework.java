package Overall.SeleniumFramework1;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import TestComponents.BaseTest;
import program.pageobjects.Cart_page;
import program.pageobjects.Check_out_page;
import program.pageobjects.Landing_page;
import program.pageobjects.ProductCatalogue;

import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_framework extends BaseTest {

	
		
		
		@Test(dataProvider="getData")
		public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
		{
			
		 
		new1.Gotopage();
		new1.loginapplication(input.get("email"), input.get("password"));
		System.out.println("wtf");
		
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		ProductCatalogue newproducts = new ProductCatalogue(driver);
		List<WebElement> products = newproducts.getproductnames();
		newproducts.clickonproducts(products);

		Cart_page clickoncart = new Cart_page(driver);
		clickoncart.click_on_Cart();
		
		
		Check_out_page checkout = new Check_out_page(driver);
		checkout.choosecountry();
		checkout.submitbutton();
		
	}
		
		@DataProvider
		public Object[][] getData() throws IOException
		{
			HashMap<Object,Object> map = new HashMap<Object,Object>();
			List<HashMap<String,String>> data = getJsondatatomap(System.getProperty("D:\\eclipse\\SeleniumFramework1\\src\\test\\java\\Alldata_1\\DataReader.java"));
			
			return new Object[][] {{data.get(0)} ,{} };
			
		}

}
