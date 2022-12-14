package fb.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import fb.qa.utilities.TestUtil;
import fb.qa.utilities.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase() {
		
		try {
			
			prop = new Properties();
			FileInputStream ip  = new FileInputStream("C:\\Salenium_Workspace\\FacebookTest\\src\\main\\java\\fb\\qa\\config\\config.properties");
	       prop.load(ip);
		
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		} 
	}
		public static void initialization() {
			
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\SaleniumJars\\chromedriver.exe");
			        driver = new ChromeDriver();
			}else if(browserName.equals("FireFox")){
				System.setProperty("webdriver.gecko.driver", "C:\\SaleniumJars\\geckodriver.exe");
				  driver = new FirefoxDriver();
			}
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}


}