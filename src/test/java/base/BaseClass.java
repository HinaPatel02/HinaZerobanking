package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import busyqa.util.MonitoringMail;
import busyqa.util.TestConfig;
import busyqa.util.Xls_Reader;


public class BaseClass {

	/*
	 * Initialise Webdriver, properties, xls ,creating db connection, generating
	 * logs
	 */

	public static Properties config = new Properties();
	public static Xls_Reader excel = null;
	public static WebDriver driver = null;
	public static Logger app_logs = Logger.getLogger("BaseClass");
	
	
	@BeforeSuite()
	public static void init() throws IOException {
		if (driver == null) {
			// load config property file
			FileInputStream fis = new FileInputStream(
			System.getProperty("user.dir") + "\\resources\\config.properties");
			config.load(fis);
			app_logs.debug("loading the config property file");

			// load excel file
			excel = new Xls_Reader(
			System.getProperty("user.dir") + "\\resources\\testdata.xlsx");
			app_logs.debug("loading the excel file");

			if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Naresh\\oxygen-workspace\\FrameworkDemo2\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Naresh\\oxygen-workspace\\FrameworkDemo2\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("edge")) {
				System.setProperty("webdriver.edge.driver", "C:\\Users\\Naresh\\oxygen-workspace\\FrameworkDemo2\\executables\\IEDriverServer.exe");
				driver = new EdgeDriver();
			}

			driver.get(config.getProperty("testsiteURL"));
			driver.manage().window().maximize();

			// Global implicit Wait
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}
	}

	@AfterSuite()
	public static void tearDown() throws AddressException, MessagingException, IOException {
		MonitoringMail mail = new MonitoringMail();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\Naresh\\oxygen-workspace\\busyqa\\test-output\\Logintest.html"));
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody,
				TestConfig.attachmentPath, TestConfig.attachmentName);
		driver.quit();
	}
}
