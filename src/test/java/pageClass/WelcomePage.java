package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage {
	
	
	WebDriver driver;
	@FindBy(id="signin_button")
		public WebElement signInBtn;
		
	
	public void ClickSignInBtn()
	
	{
		
		signInBtn.click();
	}
		
}
