package program.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import programs.Abstractcomponents.AbstractComponents;

public class Order_page extends AbstractComponents{
	
	WebDriver driver;
	
	public Order_page(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public void click_on_Cart() throws InterruptedException
	{
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("[routerlink*='cart'")).click();
		Scroll_till_end(driver.findElement(By.xpath("//button[normalize-space()='Checkout']")));
	}
	
	public void Verifyorderpage(String Productcode)
	{
		List<WebElement> listofelements = driver.findElements(By.xpath("//td[2]"));
		listofelements.stream().anyMatch(s->s.getText().equalsIgnoreCase(Productcode));
	}

}
