package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropBoxHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Sukhwinder\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//launch chrome
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();	
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//this wait is for all elements to get loaded.
		
		driver.get("http://www.jquery-az.com/boots/demo.php?ex=63.0_2");//enter URL
		
		driver.findElement(By.xpath("//span[text()='HTML, CSS']")).click();
		
		List <WebElement> list = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect')]//li//a//label"));
		
		System.out.println(list.size());
		
		//selecting all the checkboxes/options
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			//boolean Selected=list.get(i).isSelected();
			//System.out.println(Selected);
			//if(Selected == true) {
			//	System.out.println("is selected");
			//}
			///else {
			list.get(i).click();
			//}
		}
		//selecting Angular
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("Angular")) {
				list.get(i).click();
				break;
			
		}
		}
		
	}

}
