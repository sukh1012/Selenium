package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderSelectTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Sukhwinder\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//launch chrome
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();	
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//this wait is for all elements to get loaded.
		
		driver.get("https://ui.freecrm.com/");//enter URL
		
		driver.findElement(By.name("email")).sendKeys("sukhwinder_101291@yahoo.com");
		driver.findElement(By.name("password")).sendKeys("ravinder");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[contains(@class, 'ui fluid')]")).click();// login button
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"main-nav\"]/a[2]/span")).click();
		Thread.sleep(2000);
		
		
		String date="18-November-2019";
		String dateArr[] = date.split("-"); // {18,November,2019}
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		
		//             										 				row   		 column
		//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[1]
		//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[3]/div[1]/div[1]
		//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[4]/div[1]/div[1]
		//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[5]/div[1]/div[2]
		//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[3]/div[1]/div[3]
		//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[3]/div[1]/div[4]
		//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[3]/div[1]/div[5]
		//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[5]/div[1]/div[6]
		
		
		String beforeXpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[";
		String afterXpath="]/div[1]/div[";
		
		final int totalWeekDays=7;
		
		//1-1 1-2 1-3 1-4 1-5 1-6 1-7
		//2-1 2-2 2-3 2-4 2-5 2-6 2-7
		for(int rowNum=1; rowNum<=7;rowNum++) {
			for(int colNum=1; colNum<=totalWeekDays; colNum++) {
			String dayVal = driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + "]")).getText();
				System.out.println(dayVal);
				
				
			}
		}
		
		
		
	}

}
