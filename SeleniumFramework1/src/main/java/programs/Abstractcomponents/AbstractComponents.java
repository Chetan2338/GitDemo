package programs.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import program.pageobjects.Order_page;

public class AbstractComponents {

	WebDriver driver;
	public AbstractComponents(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void Wait_till_then(By findby)
	{
		
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void till_invisible(WebElement WebElement1)
	{
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.invisibilityOf(WebElement1));
	}
	
	public void Scroll_till_end(WebElement ab) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",ab );
		Thread.sleep(2000);
	}
	
	public Order_page OrdersPage_return()
	{
		driver.findElement(By.xpath("//body //app-sidebar //li[3]")).click();
		Order_page orderspage = new Order_page(driver);
		return orderspage;
	}
}
