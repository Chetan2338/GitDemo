package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import program.pageobjects.Landing_page;

public class BaseTest {
	
	public WebDriver driver;
	public Landing_page new1;
	public WebDriver initialize_Driver() throws IOException
	{
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream("D:\\eclipse\\SeleniumFramework1\\src\\test\\java\\Properties1\\Global_data.properties");
	prop.load(fis);
	 
	String browsername = prop.getProperty("browser");
	if(browsername.equalsIgnoreCase("Chrome"))
	{
	System.setProperty("webdriver.chrome.driver", "D:/eclipse/Chromedriver/chromedriver_win64/chromedriver.exe");
	 driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	}
	return driver;
	}
	

	public List<HashMap<String, String>> getJsondatatomap(String Filepath) throws IOException
	{
		String JsonContent =FileUtils.readFileToString(new File(Filepath));
		//String to Hasmap
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>(){});
			return data;
	}
	
	public String Screenshot(String testcasename,WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+ testcasename  + ".png");
		FileUtils.copyFile(source, file);
		return (System.getProperty("user.dir")+"//reports//"+ testcasename  + ".png");
	}
	
	@BeforeMethod
	public Landing_page lauchApplication() throws IOException
	{
		driver = initialize_Driver();
		 new1 = new Landing_page(driver);
		return new1;
	
	}
	
	@AfterMethod
	public void driverclose()
	{
		driver.close();
	}
}
