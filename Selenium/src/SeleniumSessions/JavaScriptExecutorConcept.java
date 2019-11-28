package SeleniumSessions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Sukhwinder\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();//launch chrome
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();	
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//this wait is for all elements to get loaded.
		
		driver.get("https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=110");
		
		driver.findElement(By.id("email")).sendKeys("SukhwinderS1.softprodigy@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Softprodigy1234&");
		
		//JavascriptExecutor is a class and we have to cast our driver into JavascriptExecutor.
		//executeScript method - to execute JavaScript code
		
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"loginbutton\"]"));//sign in button
				
		flash(loginBtn, driver);//highlight the element
		
		drawBorder(loginBtn, driver);//draw a border
		
		//take screenshot:
		//Take screenshot and store as a file format
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//now copy the screenshot to desired location using copyFile method
		FileUtils.copyFile(src, new File("C:\\Users\\Sukhwinder Singh\\eclipse-workspace\\Selenium\\src\\SeleniumSessions\\yahoo.png"));
		
		//generate Alert
		//generateAlert(driver,"There is an issue with login button");
		
		//click on any element by using JS executor
		clickElementByJS(loginBtn, driver);
		
		//refresh the page
		//1. by using selenium
		driver.navigate().refresh();
		
		//2. by using JS executor:
		refreshBrowserByJS(driver);
		
		//get the title of the page by JS:
		System.out.println(getTitleByJS(driver));
		
		//get the page text:
		System.out.println(getPageInnerText(driver));
		
		//scroll page down
		//scrollPageDown(driver);
		
		WebElement aboutLink = driver.findElement(By.xpath("//a[contains(text(), 'About')]"));
		scrollIntoView(aboutLink, driver);
		
		
	}

	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0;i<10;i++) {
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgcolor,element,driver);
		}
		
	}
	public static void  changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			
		}
	}
	
	public static void drawBorder(WebElement element, WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void generateAlert(WebDriver driver,String message) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+ message +"')");
	}
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		//arguments[0] means 1 element
		js.executeScript("arguments[0].click();", element);
	}
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("return document.title;").toString();	
		return title;
	}
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	public static void scrollPageDown(WebDriver driver) {//scroll to the bottom of the page
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public static void scrollIntoView(WebElement element, WebDriver driver) {//scroll upto the element passed
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
}
