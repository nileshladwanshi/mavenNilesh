package pomCoverfox;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthPlanResult {

	@FindBy(xpath ="//div[contains(text(),'matching Health')]") private WebElement resultDisplay;
	@FindBy(id = "plans-list")private List<WebElement> planList;
	@FindBy(className = "mb__action-box")private WebElement sortDisplayed;
	
	public HealthPlanResult(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public int textResult1()
	{
		String resultOfList=resultDisplay.getText();
		
		String ar[]=resultOfList.split(" ");
		
		String numberOfResultOfString=ar[0];
		
		int numOfResultInInt=Integer.parseInt(numberOfResultOfString);
		
		return numOfResultInInt;
 
}
	public int bannerResult1()
	{
			 
	 int totalnumOfList = planList.size();
	return totalnumOfList;
}
public Boolean isdisplay()
{
	boolean sortPlan = sortDisplayed.isDisplayed();
	
	return sortPlan  ;
	
}     
		
	}
