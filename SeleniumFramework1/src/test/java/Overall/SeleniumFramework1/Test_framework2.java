package Overall.SeleniumFramework1;

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
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;  
public class Test_framework2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		List<String> productnames = new ArrayList<String>(Arrays.asList("IPHONE 13 PRO","ZARA COAT 3"));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("chetan.jayaraja@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("GGwtf_121");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		System.out.println("wtf");
		List<WebElement> abc = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
		System.out.println(abc.size());
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		for(int i =0; i<productnames.size();i++)
			
		{
		    int j =i;
		System.out.println(productnames.size());
		WebElement ab = abc.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(productnames.get(j))).findFirst().orElse(null);
		System.out.println(ab.getText());
		Thread.sleep(1000);
		ab.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		}

		
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("[routerlink*='cart'")).click();
		WebElement gg= driver.findElement(By.xpath("//div[@class='cartSection']/h3"));
		String productnamecart= gg.getText();
		System.out.println(productnamecart);
		Assert.assertTrue(productnamecart.contains(productnamecart));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//button[normalize-space()='Checkout']")) );
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		List<WebElement> countrieslist = driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
		WebElement country =countrieslist.stream().filter(s->s.getText().equals("India")).findFirst().orElse(null);
		country.click();
		driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
		String var = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(var, "Thankyou for the order.");
	}

}
