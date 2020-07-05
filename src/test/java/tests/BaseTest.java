package tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected WebDriver driver;
	
	 @BeforeTest
	 public void setUpDriver() throws MalformedURLException
	    {
		 //BROWSER=> chrome / firefox
		 //HUB_HOST=> localhost / 10.0.1.3 / hostname
		 String host="localhost";
		 DesiredCapabilities dc;
		 if(System.getProperty("BROWSER")!= null && System.getProperty("BROWSER").equalsIgnoreCase("firefox"))
		 {
			 dc=DesiredCapabilities.firefox();
		 }
		 else
		 {
			 dc=DesiredCapabilities.chrome();
		 }
		 
		 if(System.getProperty("HUB_HOST")!=null)
		 {
			 host=System.getProperty("HUB_HOST");
		 }
	    String completeURL="http://192.168.99.100:4444/wd/hub";
	    this.driver=new RemoteWebDriver(new URL(completeURL),dc); 
	    }
	 
	 @AfterTest
	 public void quitdriver() 
	 {
		 driver.quit();
	 }
}
  