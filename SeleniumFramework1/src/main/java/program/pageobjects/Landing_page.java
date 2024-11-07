package program.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import programs.Abstractcomponents.AbstractComponents;

public class Landing_page extends AbstractComponents {

	WebDriver driver1;

		public Landing_page(WebDriver driver)
		{
			super(driver);
			this.driver1 = driver;
		}
		
	
		
		public void loginapplication (String email, String Password)
		
		{
			WebElement UserEmail =driver1.findElement(By.xpath("//input[@type='email']"));
			WebElement PasswordEle = driver1.findElement(By.xpath("//input[@type='password']"));
			WebElement login =driver1.findElement(By.xpath("//input[@id='login']"));
			UserEmail.sendKeys(email);
			PasswordEle.sendKeys(Password);
			login.click();
		}
		
		public void Gotopage()
		{
			driver1.get("https://rahulshettyacademy.com/client");
		}
		
		public void checkline()
		{
			String var = driver1.findElement(By.cssSelector(".hero-primary")).getText();
			Assert.assertEquals(var, "THANKYOU FOR THE ORDER.");
		}
		
		public String get_error_message()
		{
			Wait_till_then(By.cssSelector("div[aria-label='Incorrect email or password.']"));
			String val =driver1.findElement(By.cssSelector("div[aria-label='Incorrect email or password.']")).getText();
			return val;
		}
	}

		


