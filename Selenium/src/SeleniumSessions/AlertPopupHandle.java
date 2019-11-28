package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopupHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Sukhwinder\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//launch chrome
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click(); //click on go button.
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert(); //switchTo will give one alert class object, so we are storing it in reference.
		
		System.out.println(alert.getText());
		
		String text=alert.getText();
		if(text.equals("Please enter a valid user name")) {
			System.out.println("correct alert message");
		}
		else {
			System.out.println("incorrect alert message");
		}
		
		alert.accept(); //click on ok button
		
		//alert.dismiss(); //click on cancel button
		
		
		
		
		
	}

}
