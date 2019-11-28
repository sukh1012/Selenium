package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Sukhwinder\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//launch chrome
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();	
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//this wait is for all elements to get loaded.
		
		driver.get("https://ui.freecrm.com/");
		
		driver.findElement(By.name("email")).sendKeys("sukhwinder_101291@yahoo.com");
		driver.findElement(By.name("password")).sendKeys("ravinder");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[contains(@class, 'ui fluid')]")).click();//login button
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"main-nav\"]/a[3]/span")).click();//contacts tab
		
		Thread.sleep(4000);
		
		//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]
		//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td[2]
		//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[3]/td[2]
		
		//Method 1
		String before_xpath = "//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[";
		String after_xpath = "]/td[2]";
		
//		for(int i=1; i<=3; i++) {
//			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
//			System.out.println(name);
//			if(name.equals("Tom Peter")) {//i=2
//				//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/div/label
//				//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td[1]/div/label
//				System.out.println("test");
//				driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[" + i + "]/td[2]")).click();
//				System.out.println("testing");
//			}
//				
//		}
//		
		//Method 2
		//for next sibling, use 'forwarding-sibling'
		//for going to parent, use 'Parent'
		//For future, we just need to change the text which we are passing. other xpath will remain same.
		//driver.findElement(By.xpath("//td[contains(text(),'Sam Peter')]/preceding-sibling::td//input[@name='id']")).click();
		driver.findElement(By.xpath("//td[text()='Sam Peter']//preceding-sibling::td//div//label")).click();
		
		
	}

}
