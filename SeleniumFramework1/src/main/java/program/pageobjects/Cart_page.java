package program.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import programs.Abstractcomponents.AbstractComponents;

public class Cart_page extends AbstractComponents{
	
	WebDriver driver;
	
	public Cart_page(WebDriver driver)
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

}
