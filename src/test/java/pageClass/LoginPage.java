package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/***********This is testing code**********/
public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="user_login")
	public WebElement UserNameTextBox;

	
	@FindBy(id="user_password")
	public WebElement PasswordTextBox;
	
	
	@FindBy(name="submit")
	public WebElement SubmitBtn;
	
	
	
	public void dologin(String myusername,String mypassword)
	{
		
		UserNameTextBox.sendKeys(myusername);
		
		PasswordTextBox.sendKeys(mypassword);
		
		SubmitBtn.click();
	}
	
	
	
	
	
}
