package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClass.LoginPage;
import pageClass.WelcomePage;

public class TC_01_VerifyLogin {
	
	
	public WebDriver driver;
	public WelcomePage wp;
	public LoginPage  lp;
	
	
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hina\\eclipse-workspace\\zerobankingnew\\src\\test\\resources\\browser_drivers\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		wp=PageFactory.initElements(driver, WelcomePage.class);
		lp=PageFactory.initElements(driver, LoginPage.class);
	}
	
	@Test
	
	public void verifyLogin()
	{
		
		//SoftAssert asr = new SoftAssert();
		// wp =  new WelcomePage();
		 wp.ClickSignInBtn();
		 //lp=new LoginPage();
		 lp.dologin("username", "password");
	/*	String Actual=driver.getTitle();
		 String Expected="Zero - Personal Banking - Loans - Credit Cards";
		 asr.assertEquals(Actual, Expected);
		 
		 asr.assertAll();*/
		 
	}
	
	@AfterClass
	
	public void tearDown()
	{
		
		driver.quit();
	}

}
