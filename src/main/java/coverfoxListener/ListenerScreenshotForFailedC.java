package coverfoxListener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverfoxBase.*;
//import coverfoxUtility.*;

public class ListenerScreenshotForFailedC extends BaseUsage implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log(" TC "+result.getName()+" is failed, please check again", true);
		try 
		{
			coverfoxUtility.utilitClass.screenShot(driver, result.getName());
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log(" TC "+result.getName()+" is skipped, please check dependent", true);	
	}
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		Reporter.log(" TC "+result.getName()+" execution is started", true);		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String name = result.getName();
		Reporter.log(" TC "+name+" is completed succesfull", true);
		
		
	}
	
	
	

}
