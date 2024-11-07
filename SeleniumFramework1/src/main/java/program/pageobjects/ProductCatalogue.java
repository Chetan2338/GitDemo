package program.pageobjects;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import programs.Abstractcomponents.AbstractComponents;


public class ProductCatalogue extends AbstractComponents {
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	WebDriver driver ;
	
	//private declarations.
	

	public List<WebElement> getproductnames()
	{
		List<WebElement> productslist  = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
		return productslist;
	}
	
	
	public void clickonproducts(List<WebElement> productslist) throws InterruptedException
	{
		
		
		
		List<String> productnames = new ArrayList<String>(Arrays.asList("IPHONE 13 PRO","ZARA COAT 3"));
		for(int i =0; i<productnames.size();i++)
			
		{
		    int j =i;
		System.out.println(productnames.size());
		WebElement ab = productslist.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(productnames.get(j))).findFirst().orElse(null);
		System.out.println(ab.getText());
		Thread.sleep(1000);
		ab.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		Wait_till_then(By.id("toast-container"));
		}
	}
	
	
	
}
