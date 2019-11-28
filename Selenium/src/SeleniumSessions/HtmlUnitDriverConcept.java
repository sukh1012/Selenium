package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Sukhwinder\\Selenium\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();//launch chrome
		
		//htmlunitdriver is not available in selenium 3.x version.
		//htmlunitdriver -- to use this concept, we have to download htmlunitdriver JAR file.
		//advantages:
		//1. testing happens behind the scene.  i.e. no browser get launched.
		//2. very fast -- execution of test cases -- performance of the script is improved.
		//3. not suitable for Actions class i.e. user actions. eg: mousemovement, doubleClick, drag&drop
		//This is also called Ghost driver/Headless driver
		WebDriver driver= new HtmlUnitDriver();
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();	
		
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//this wait is for all elements to get loaded.
		
		driver.get("https://accounts.google.com/signin/v2/identifier?sacu=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin#identifier");
		
		System.out.println("Before login, title is ==" + driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("pranavc.softprodigy@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"next\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"Passwd\"]")).sendKeys("Softprodigy@123");
		
		driver.findElement(By.xpath("//*[@id=\"signIn\"]")).click();
		
		System.out.println("After login, title is ==" + driver.getTitle());
		
		
		
	}

}
