package Utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class testBase {

	
	public static WebDriver driver =null;
	public static FileInputStream fis;
	public static Properties prop;
	
	//Constructor for initialising properties
	public testBase() {
	
		try {
			String path = System.getProperty("user.dir");
			//System.out.println(path);
			fis = new FileInputStream(path + "/src/test/java/Utils/data.properties");
			prop = new Properties();
			prop.load(fis);
		}
		catch (Exception e) {
			System.out.println("Initializing properties file - failed");
		}
	}
	
	//Initialising the driver
	@BeforeSuite	
	public void Initialisation() throws InterruptedException {
		
		String url = prop.getProperty("url");
		String OSName = prop.getProperty("OS");
		System.out.println(OSName);
		String BrowserName = prop.getProperty("browser");
		System.out.println(BrowserName);
		
		
		//for Linux and Chrome
		if(BrowserName.equalsIgnoreCase("chrome") && OSName.equalsIgnoreCase("linux"))  {
			
			System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
			
			driver = new ChromeDriver();
			}
		
		else if(BrowserName.equalsIgnoreCase("firefox") && OSName.equalsIgnoreCase("linux")) {
			
			System.setProperty("webdriver.gecko.driver", "/usr/bin/chromedriver");
			
			driver = new FirefoxDriver();	
		}
			
			else if(BrowserName.equalsIgnoreCase("chrome") && OSName.equalsIgnoreCase("Windows")) {
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				
				driver = new ChromeDriver();

			}
			
			else if(BrowserName.equalsIgnoreCase("firefox") && OSName.equalsIgnoreCase("Windows")) {
				
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/firefoxdriver.exe");
				
				driver = new FirefoxDriver();	
			}
			
			else if(BrowserName.equalsIgnoreCase("internetexplorer") && OSName.equalsIgnoreCase("Windows")) {
				
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/Inedge_Files/IEDriver/IEDriverServer.exe");
	           
	             driver = new InternetExplorerDriver();
			}
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			
		
		
	}
	

	//Method to explicitly wait
	public void ExplicitWait(int wait) {
		 WebDriverWait ww = new WebDriverWait(driver, wait);
	}
//	@AfterSuite
//	public void tearDown() {
//		driver.close();
//	}
}
