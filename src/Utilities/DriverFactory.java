package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
// will return a webdriver object
	public static WebDriver open(String browserType) {
		
		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Mokslai\\WEB\\Selenium\\Software\\chromedriver.exe");
			return new ChromeDriver();
			//System.out.println("using Chrome");
		}
		else if (browserType.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Desktop\\Mokslai\\WEB\\Selenium\\Software\\geckodriver.exe ");
			return new FirefoxDriver();
			//System.out.println("using Firefox");
		}
		else if (browserType.equals("IE")) {	//nepaspaudzia mygtuko
			System.setProperty("webdriver.ie.driver", "C:\\Users\\User\\Desktop\\Mokslai\\WEB\\Selenium\\Software\\IEDriverServer.exe");
			return new InternetExplorerDriver();
			//System.out.println("using Internet Explorer");
		}
		else {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Mokslai\\WEB\\Selenium\\Software\\chromedriver.exe");
			return new ChromeDriver();
			//System.out.println("using Default, Crome");
		}
	}
	
}
