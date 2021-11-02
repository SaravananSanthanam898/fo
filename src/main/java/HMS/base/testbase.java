package HMS.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import HMS.utility.WebEventListener;

public class testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener listnr;
	public static EventFiringWebDriver evntfrng;
	 
	
	public testbase()
	{
		
		prop =new Properties();
		
		try {
			FileInputStream fconfig=new FileInputStream("./src/main/java/HMS/config/config.properties");
			prop.load(fconfig);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browsername=prop.getProperty("BROWSER");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
			driver=new ChromeDriver();
	    }else if(browsername.equals("opera"))
	    {
	    	System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/operadriver.exe");
	    	driver=new OperaDriver();
	    }
		
		//basic method
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		
		//Event Firing Script
		listnr=new WebEventListener();
		evntfrng=new EventFiringWebDriver(driver);
		evntfrng.register(listnr);
		driver=evntfrng;
		
		
		
	}
	public void waitforvisibility(WebElement webE)
	{
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(webE));
	}
	
	
	
	
	

}
