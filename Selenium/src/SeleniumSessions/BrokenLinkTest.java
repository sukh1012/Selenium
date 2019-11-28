package SeleniumSessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Sukhwinder\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//launch chrome
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();	
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//this wait is for all elements to get loaded.
		
		driver.get("https://facebook.com");//enter URL
		
		//driver.findElement(By.name("email")).sendKeys("sukhwinder_101291@yahoo.com");
		//driver.findElement(By.name("password")).sendKeys("ravinder");
		//Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//div[contains(@class, 'ui fluid')]")).click();//login button
		
		Thread.sleep(2000);
		
		//links --- a html tag --- href<http://www.google.com>
		//images ---img html tag --- href<www.test.com>
		//if href is not available, we will not test that link/img as it can be by requirement.
		
		//1. get the list of all the links and images:
		List <WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("size of all links and images--->"+ linksList.size());
		Thread.sleep(2000);
		//active means having href property
		List <WebElement> activeLinks = new ArrayList<WebElement>();
		
		//2. Iterate linksList: exclude all the links/images which doesn't have any href attribute
		for(int i=0; i<linksList.size(); i++) {
			System.out.println(linksList.get(i).getAttribute("href"));
			if(linksList.get(i).getAttribute("href") != null && (! linksList.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(linksList.get(i));
				
			}
		}
		
		//get the size of active links list
		System.out.println("size of active links and images--->"+ activeLinks.size());
		
		//3. check the href url, with httpconnection api:
		//200 - ok
		//404 - not found
		//500 - internal error
		//400 - bad request
		for(int j=0; j<activeLinks.size(); j++) {
			HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			String response = connection.getResponseMessage();//check if the url is correct or not
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+ "--->"+ response);
		}
		
		
		
		
		
	}

}
