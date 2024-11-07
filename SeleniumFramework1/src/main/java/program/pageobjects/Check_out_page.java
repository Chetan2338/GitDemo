package program.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Check_out_page{
	
	
	WebDriver driver;
	public Check_out_page(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void choosecountry()
	{
		driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		List<WebElement> countrieslist = driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
		WebElement country =countrieslist.stream().filter(s->s.getText().equals("India")).findFirst().orElse(null);
		country.click();
	}
	
	public void submitbutton()
	{
		driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
	}
	
	

}
