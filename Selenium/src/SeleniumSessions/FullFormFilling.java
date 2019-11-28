package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FullFormFilling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Sukhwinder\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//launch chrome
		driver.get("https://login.yahoo.com/account/create?.src=fpctx&.intl=in&.lang=en-IN&.done=https%3A%2F%2Fin.yahoo.com&specId=yidReg");//enter url
		
		driver.findElement(By.id("usernamereg-firstName")).sendKeys("Tom");
		driver.findElement(By.id("usernamereg-lastName")).sendKeys("Peter");
		driver.findElement(By.id("usernamereg-yid")).sendKeys("Tom_101291");
		driver.findElement(By.id("usernamereg-password")).sendKeys("Softprodigy");
		driver.findElement(By.id("usernamereg-phone")).sendKeys("9165447238");
		
		Select select=new Select(driver.findElement(By.id("usernamereg-month")));
		select.selectByVisibleText("December");
		
		driver.findElement(By.id("usernamereg-day")).sendKeys("10");
		driver.findElement(By.id("usernamereg-year")).sendKeys("1991");
		
		driver.findElement(By.id("reg-submit-button")).click();
		
		
	
		
		
		
	}

}
