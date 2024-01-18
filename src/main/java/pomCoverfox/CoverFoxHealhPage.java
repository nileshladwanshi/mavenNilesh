package pomCoverfox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFoxHealhPage {

	
		@FindBy(xpath = "//div[@class='next-btn']") private WebElement nextButton;
		
		
		public CoverFoxHealhPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);						
	}

		public void ClickOnNext()
		{
			nextButton.click();						
		}

}
