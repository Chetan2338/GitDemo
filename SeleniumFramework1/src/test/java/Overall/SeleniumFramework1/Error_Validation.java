package Overall.SeleniumFramework1;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import TestComponents.BaseTest;
import TestComponents.Retry;
import program.pageobjects.Cart_page;
import program.pageobjects.Check_out_page;
import program.pageobjects.Order_page;
import program.pageobjects.ProductCatalogue;

import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;  
public class Error_Validation extends BaseTest{


	@Test(groups= {"Smoke"})
	public void submitOrder() throws IOException, InterruptedException
	{
		
	 
	new1.Gotopage();
	new1.loginapplication("chetan.jayaraja@gmail.com", "GGtf_121");
	String val =new1.get_error_message();
	Assert.assertEquals(val, "Incorrect email or password.");

	}
	@Test(groups= {"Smoke"})
	public void ProductErrorValidation() throws IOException, InterruptedException
	{
		
	 
	new1.Gotopage();
	new1.loginapplication("chetan.jayaraja@gmail.com", "GGwtf_121");
	
	
	WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
	ProductCatalogue newproducts = new ProductCatalogue(driver);
	List<WebElement> products = newproducts.getproductnames();
	newproducts.clickonproducts(products);
	
	
	
	
}
	
@Test(dependsOnMethods = {"ProductErrorValidation"}, retryAnalyzer= Retry.class)
public void OrderHistorytest()
{
	new1.Gotopage();
	new1.loginapplication("chetan.jayaraja@gmail.com", "GGwtf_121");
	Order_page ab =new1.OrdersPage_return();
	Assert.assertTrue(false);
	
}

}
