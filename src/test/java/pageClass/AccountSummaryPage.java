package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSummaryPage {
	
	
	WebDriver driver;
	@FindBy (xpath="//a[text()='Pay Bills']")
	public WebElement PayBillsLink;
	
	
	public void ClickOnPayee()
	{
		PayBillsLink.click();
	}

}
