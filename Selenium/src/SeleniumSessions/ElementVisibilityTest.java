package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Sukhwinder\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//launch chrome
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();	
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//this wait is for all elements to get loaded.
		
		driver.get("https://www.facebook.com/r.php");
		//1. isDisplayed() method: applicable for all the elements
		//if the element is visible/available on the page, it will return true otherwise false.
		boolean b1 = driver.findElement(By.id("u_0_14")).isDisplayed();//for signup button
		System.out.println(b1);//true
		
		//2. isEnabled() method:
		//to check if some visible/ava element is enabled or disabled
		//primarily used for buttons
		boolean b2 = driver.findElement(By.id("u_0_14")).isEnabled();
		System.out.println(b2);//true
		
		//3. isSelected() method: only applicable for checkbox, dropdown, radiobutton
		//to check if the webelement is selected or not
		driver.findElement(By.xpath("//*[@id=\"u_0_7\"]")).click();
		boolean b3 = driver.findElement(By.xpath("//*[@id=\"u_0_7\"]")).isSelected();
		System.out.println(b3);//true
		
		//de-select the radio button: by selecting other radio button
		driver.findElement(By.xpath("//*[@id=\"u_0_6\"]")).click();
		boolean b4 = driver.findElement(By.xpath("//*[@id=\"u_0_7\"]")).isSelected();
		System.out.println(b4);//false
		
		
	}

}
