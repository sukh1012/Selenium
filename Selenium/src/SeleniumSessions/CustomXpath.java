package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Sukhwinder\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//launch chrome
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();	
		
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//this wait is for all elements to get loaded.
		
		driver.get("https://ebay.com");
		
		//absolute xpath - not recommended
		//*/div/div[2]/table/tbody/tr/td[2]/input
		//1.performance issue
		//2. not reliable
		//3. can be changed at any time in future.
		
		//we can use any attribute instead of class. format - "//HtmlTag[@Attribute='Attributename']"
		//driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("Java");
		
		//@class like 'gh-tb' . So contains can be used to handle dynamic ids i.e. where id is not constant.
		//driver.findElement(By.xpath("//input[contains(@class,'gh-tb')]")).sendKeys("Java");
		
		//Another method to handle dynamic ids
		driver.findElement(By.xpath("//input[starts-with(@class,'gh-tb')]")).sendKeys("Java");
		//driver.findElement(By.xpath("//input[ends-with(@class,'input')]")).sendKeys("Java");
		
		//for links - custom xpath
		//all the links are represented by <a> html tag.
		driver.findElement(By.xpath("//a[contains(text(),'Sell')]")).click();
		
		
		
		
	}

}
