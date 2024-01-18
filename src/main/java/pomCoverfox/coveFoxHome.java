package pomCoverfox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class coveFoxHome 
{
	
	//@FindBy( xpath = "//div[text()='Male']")private WebElement maleButton;
	@FindBy(xpath = "//button[@title='Get Started']")private WebElement nextButton;
	
	public coveFoxHome(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);		
	}
	
//	public void clickOnMaleButton()
//	{
//		maleButton.click();
//	}
	
	public void clickOnNextBut() 
	{
		nextButton.click();
	}
	
	
	
	
	
	
}
