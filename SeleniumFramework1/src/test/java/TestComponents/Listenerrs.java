package TestComponents;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import Properties1.ExtentReports1;

public class Listenerrs extends BaseTest implements ITestListener
{
	
	ExtentTest test;
	ExtentReports reports = ExtentReports1.Extentreportgenerator();
	
	@Override
public void onTestStart(ITestResult result)
{
		reports.createTest(result.getMethod().getMethodName());
}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, "Test Pass");
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		test.fail(result.getThrowable());
		String filepath =null;
		try {
			 filepath = Screenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		reports.flush();
	}
	
	
}

