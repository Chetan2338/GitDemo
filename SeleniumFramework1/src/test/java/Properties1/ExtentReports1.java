package Properties1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports1 {
	
	
	public static ExtentReports Extentreportgenerator()
	{
	String path = System.getProperty("user.dir") + "\\reports\\index.html";
	ExtentSparkReporter report = new ExtentSparkReporter(path);
	report.config().setReportName("Web Automation results");
	report.config().setDocumentTitle("Whatever");
	ExtentReports allreports = new ExtentReports();
	allreports.attachReporter(report);
	allreports.createTest(path);
	return allreports;
	}
}
