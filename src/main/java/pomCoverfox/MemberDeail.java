package pomCoverfox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MemberDeail 
{
	@FindBy(id = "Age-You")private WebElement ageDropDown;
	@FindBy(className = "next-btn") private WebElement NextButton;
	
	public MemberDeail(WebDriver driver)
	{
		PageFactory.initElements(driver, this);						
	}
	
//	public void EnterAge()
//	{
//		Select s= new Select(ageDropDown);
//		s.selectByValue("25y");
//	}
	public void EnterAge(String age)
	{
		Select s= new Select(ageDropDown);
		s.selectByValue(age+"y");
	}
	
	public void ClickOnNext()
	{
		NextButton.click();
	}
	
	
	
	
	
	
	
	
	
	
}
