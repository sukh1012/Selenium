package SeleniumSessions;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FindElementsConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//how to find total number of links and their text on a page
		
		System.setProperty("webdriver.chrome.driver", "D:\\Sukhwinder\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//launch chrome
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();	
		
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//this wait is for all elements to get loaded.
		
		driver.get("https://ebay.com");
		
		//get the total count of links
		//get the text of each link on the page
		
		//all the links are represented by <a> html tag
		List <WebElement> linklist = driver.findElements(By.tagName("a")); //webelement is a class available in selenium
		//linklist is an object. we can give any name. List is available in java
		
		//size of linklist
		System.out.println(linklist.size());
		
		for(int i=0; i<linklist.size();i++) {
			String linktext=linklist.get(i).getText();
			System.out.println(linktext);
		}
		
		
		
		
	}

}
