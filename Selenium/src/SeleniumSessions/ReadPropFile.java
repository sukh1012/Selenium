package SeleniumSessions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropFile {

	static WebDriver driver;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Properties prop=new Properties();
		
		FileInputStream ip=new FileInputStream("C:\\Users\\Sukhwinder Singh\\eclipse-workspace\\Selenium\\src\\SeleniumSessions\\config.properties");
		
		prop.load(ip);
		
		System.out.println(prop.getProperty("name"));
		
		System.out.println(prop.getProperty("age"));
		
		String url=prop.getProperty("URL");
		
		System.out.println(url);
		
		String browsername=prop.getProperty("browser");
		
		System.out.println(browsername);
		
		if(browsername.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Sukhwinder\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();//launch chrome
		}else if(browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Sukhwinder\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		
		driver.get(url);
		
		driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.xpath(prop.getProperty("surname_xpath"))).sendKeys(prop.getProperty("surName"));
		driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(prop.getProperty("email"));
	}

}
