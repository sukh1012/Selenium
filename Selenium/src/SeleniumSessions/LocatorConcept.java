package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Sukhwinder\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//launch chrome
		driver.get("https://login.yahoo.com/account/create?.src=fpctx&.intl=in&.lang=en-IN&.done=https%3A%2F%2Fin.yahoo.com&specId=yidReg");//enter url
		
		//1. xpath... priority 2
		//absolute xpath should not be used. for example: html/body/div[1]/div[5]/div[2]/o
		//only relative xpath should be used. for example: //*[@id=\"usernamereg-firstName\"]
//		driver.findElement(By.xpath("//*[@id=\"usernamereg-firstName\"]")).sendKeys("Tom");
//		
//		driver.findElement(By.xpath("//*[@id=\"usernamereg-lastName\"]")).sendKeys("Peter");
//		
//		driver.findElement(By.xpath("//*[@id=\"usernamereg-yid\"]")).sendKeys("test");
		
		
		//2. id... priority 1
//		driver.findElement(By.id("usernamereg-firstName")).sendKeys("Tom");
//		driver.findElement(By.id("usernamereg-lastName")).sendKeys("Peter");
		
		//3. name... priority 3
//		driver.findElement(By.name("firstName")).sendKeys("Tom");
//		driver.findElement(By.name("lastName")).sendKeys("Peter");
		
		//4.linktext - this is only for links.
		//driver.findElement(By.linkText("Sign in")).click();
		
		//5. partial link text - not useful
		//driver.findElement(By.partialLinkText("I want to use")).click();
		
		//6. CSSSelector... priority 2(just like xpath)
		// if id is there, put #(id) in place of cssselector string text.
		//if class is there, then put #(class) in place of cssselector string text.
		driver.findElement(By.cssSelector("#usernamereg-firstName")).sendKeys("Tom");
		driver.findElement(By.cssSelector("#usernamereg-lastName")).sendKeys("Peter");
		
		//7. classname - not useful... priority 4
		driver.findElement(By.className("js-link-feedback")).click();
		
		
	}

}
