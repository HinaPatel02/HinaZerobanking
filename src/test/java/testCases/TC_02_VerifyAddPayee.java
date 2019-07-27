package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageClass.AccountSummaryPage;
import pageClass.LoginPage;
import pageClass.PayBillsPage;
import pageClass.WelcomePage;


public class TC_02_VerifyAddPayee {
	
	
	
	public WebDriver driver;
	public AccountSummaryPage ap;
	public LoginPage  lp;
	public PayBillsPage pp;
	public WelcomePage wp;
	 
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hina\\eclipse-workspace\\zerobankingnew\\src\\test\\resources\\browser_drivers\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		wp=PageFactory.initElements(driver, WelcomePage.class);
		ap=PageFactory.initElements(driver, AccountSummaryPage.class);
		lp=PageFactory.initElements(driver, LoginPage.class);
		pp=PageFactory.initElements(driver,PayBillsPage.class);
	}

@Test
	
	
public void verifyLogin()
{
	// wp =  new WelcomePage();
	 wp.ClickSignInBtn();
	 //lp=new LoginPage();
	 lp.dologin("username", "password");
	 
	 ap.ClickOnPayee();
	 pp.AddNewPayee();
	 pp.AddnewPayeeButton("HydroOne Utility","200 RoberSpec Pkwy, Mississauga, ON L6R1K9","123234434","HydroOne Utility");
	 
	
}


@AfterClass

public void tearDown()
{
	
	driver.quit();
}
	
	
}
