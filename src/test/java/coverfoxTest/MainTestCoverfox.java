package coverfoxTest;

//import java.io.IOException;
//import java.time.Duration;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pomCoverfox.AddressDeails;
import pomCoverfox.CoverFoxHealhPage;
import pomCoverfox.HealthPlanResult;
import pomCoverfox.MemberDeail;
import pomCoverfox.coveFoxHome;
 
//import io.netty.handler.codec.http.HttpContentEncoder.Result;
//import io.netty.handler.codec.http.HttpContentEncoder.Result;
//import coverfoxListener.ListenerScreenshotForFailedC;
//import coverfoxUtility.utilitClass;


@Listeners(coverfoxListener.ListenerScreenshotForFailedC.class)
public class MainTestCoverfox {
    public static Logger logger;
  
    WebDriver driver  ;
    coveFoxHome home;
    CoverFoxHealhPage healthPage;
	MemberDeail memberDetail;
    AddressDeails adress;
	HealthPlanResult healthPlan;
	//ListenerScreenshotForFailedC listener;
	
	
	@BeforeClass
 public void launchBrowser()throws InterruptedException
  {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(opt); 
		home =new coveFoxHome(driver);
		healthPage = new CoverFoxHealhPage(driver);
		adress =new AddressDeails(driver);
		memberDetail=new MemberDeail(driver);
		healthPlan =new HealthPlanResult(driver);
			
		Reporter.log("opening Browser", true);
		driver.manage().window().maximize();
		driver.get("https://www.coverfox.com/");
		Thread.sleep(1500);	
	  }
  
  @BeforeMethod  
  public void beforeMethod()throws InterruptedException
  {
//	  Thread.sleep(1500);
//	  Reporter.log("Clicking on gender button", true);
//	  home.clickOnMaleButton();
	  Reporter.log("Clicking on next button", true);
	  Thread.sleep(2500);
	  home.clickOnNextBut();


	  Thread.sleep(3500);
	  Reporter.log("Clicking on next button", true);
	  healthPage.ClickOnNext();
	  
	  Thread.sleep(1500);
	  Reporter.log("entering age", true);
	  memberDetail.EnterAge("25");
	  Thread.sleep(1500);
	  memberDetail.ClickOnNext();
	 
	  Thread.sleep(2500);
	  Reporter.log("entering pincode", true);
	  adress.enterPincode("423109");
	  Thread.sleep(1500);
	  Reporter.log("entering mobile number", true);
	  adress.enterMobileNum("8888888898");
	  Thread.sleep(1500);
	  Reporter.log("Clicking on continue button", true);
	  adress.clickOnContinue();
	    	  
  }
  
  @Test
  public void validatingTC()throws InterruptedException 
{
	  
	  logger= logger.getLogger("My New Log");
	  PropertyConfigurator.configure("log4j.properties");
	  logger.info("Comparing test");
	  
	  
	  
	  Thread.sleep(4500);
	  WebDriver driver = new ChromeDriver() ;
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	  Reporter.log("fetching number of result from text", true);
	  int textResult=healthPlan.textResult1();
	  Thread.sleep(5000);
	  
	  Reporter.log("fetching number of result from banner", true);
	  int bannerResult=healthPlan.bannerResult1();	  
	  Thread.sleep(7500);
	  Assert.assertEquals(bannerResult, textResult,"Text result and banner result are not equal,TC is failed");
	  //Assert.assertEquals(textResult,bannerResult,"Text result and banner result are not equal,TC is failed");
	  //utilitClass.screenShot(driver,"validatingTC");
}
//  @Test
//  public void sortCheck()
//  {
//  Reporter.log("Checking sort is displayed",true);
//  }
  
//  @AfterMethod
//  public void afterMethod() throws InterruptedException
//  {
//	  Thread.sleep(7500);
//	  Reporter.log("closing browser",true);
//	  Thread.sleep(3500);
//	  driver.close();
// 	}
}
