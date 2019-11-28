package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverBasics {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		//1. Firefox browser
		//geckoDriver - to launch firefox
		
		System.setProperty("webdriver.gecko.driver", "D:\\Sukhwinder\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();//Webdriver is an interface, firefoxdriver is a class.
		//above line will launch blank firefox browser.
		
		driver.get("http://www.google.com"); //enter url in firefox
		
		//2. Chrome browsers
		System.setProperty("webdriver.chrome.driver", "D:\\Sukhwinder\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver1=new ChromeDriver();//launch chrome
		driver1.get("http://www.google.com");//enter url
		
		String title= driver.getTitle();
		System.out.println(title);
		
		//validation point
		if(title.equals("Google")) {
			System.out.println("correct title");
		}
		else {
			System.out.println("Incorrect title");
		}
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver1.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		driver.quit();//to quit the browser
		driver1.quit();
		
		
	}

}
