package TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int i =0;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(i==3)
		{
		
		return false;
		}
		i=i+1;
		return true;
		
	}
	
	

}
