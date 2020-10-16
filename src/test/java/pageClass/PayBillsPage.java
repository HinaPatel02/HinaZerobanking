package pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage {
	
	WebDriver driver;
	
	/*******Practise code****************/
	
	@FindBy (xpath="//a[text()='Add New Payee']")
	public WebElement PayBillsLink;
	
	@FindBy(id="np_new_payee_name")
	public WebElement AddPayeeName;

	
	@FindBy(id="np_new_payee_address")
	public WebElement AddNewPayeeAddress;
	
	@FindBy(id="np_new_payee_account")
	public WebElement AddNewPayeeaccount;
	
	@FindBy(id="np_new_payee_details")
	public WebElement AddNewPayeeDetails;
	
	@FindBy(id="add_new_payee")
	public WebElement AddNewPayeeButton;
	
	
	
	public void AddNewPayee()
	{
		PayBillsLink.click();
	}
	
	
	public void AddnewPayeeButton(String PName,String PAddress,String PAccount,String PDetails)
	{
		AddPayeeName.sendKeys(PName);
		AddNewPayeeAddress.sendKeys(PAddress);
		AddNewPayeeaccount.sendKeys(PAddress);
		AddNewPayeeDetails.sendKeys(PAccount);
		AddNewPayeeButton.click();
	}
	}

