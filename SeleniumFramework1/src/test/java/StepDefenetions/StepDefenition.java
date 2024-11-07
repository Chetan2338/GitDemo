package StepDefenetions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import program.pageobjects.Cart_page;
import program.pageobjects.Check_out_page;
import program.pageobjects.Landing_page;
import program.pageobjects.ProductCatalogue;

public class StepDefenition extends BaseTest {

	public Landing_page landingpage;
	
	@Given("Given I landed on E-Commerce site.")
	public void I_Landed_on_E_commerce_site() throws IOException
	{
		landingpage = lauchApplication();	
		
	}
	
	@Given("^I logged in username (.+) and password (.+)$")
	
	public void logged_in_username(String username, String Password)
		{
		new1.loginapplication(username, Password);
		}
	@When("^When add the product (.+) to the code$")
		public void When_I_add_product() throws InterruptedException
		{
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		ProductCatalogue newproducts = new ProductCatalogue(driver);
		List<WebElement> products = newproducts.getproductnames();
		newproducts.clickonproducts(products);
		
		}
	
	@When("^And checkout (.+) and submit the order$")
	public void Checkout_and_Submit_the_order() throws InterruptedException
	{
		Cart_page clickoncart = new Cart_page(driver);
		clickoncart.click_on_Cart();
	}

		@Then("message is displayed on confirmationpage") 
		public void checkorder()
		{
			Check_out_page checkout = new Check_out_page(driver);
			checkout.choosecountry();
			checkout.submitbutton();
		}
	
}
