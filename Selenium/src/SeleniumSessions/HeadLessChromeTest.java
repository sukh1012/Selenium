package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessChromeTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Sukhwinder\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		//mandatory options:
		//1. For chromeoptions to work, your chrome version should be greater than 50 in mac and greater than 60 in windows.
		//2. window-size=1400,800
		ChromeOptions options= new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		
		WebDriver driver=new ChromeDriver(options);//launch chrome
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();	
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//this wait is for all elements to get loaded.
		
		driver.get("https://ui.freecrm.com/");
		
		System.out.println("login page title == " + driver.getTitle());
		
		driver.findElement(By.name("email")).sendKeys("sukhwinder_101291@yahoo.com");
		driver.findElement(By.name("password")).sendKeys("ravinder");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[contains(@class, 'ui fluid')]")).click();//login button
		
		System.out.println("home page title == " + driver.getTitle());
		
	}

}
