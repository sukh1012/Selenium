package testNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {

	/*
	 * @BeforeSuite ---setup system property for chrome
	@BeforeTest ---launch chrome browser
	@BeforeClass ---login to app
	
	@BeforeMethod ---enter url
	@Test ---google logo test
	@AfterMethod ---logout from app
	
	@BeforeMethod ---enter url
	@Test ---Google title test
	@AfterMethod ---logout from app
	
	@BeforeMethod ---enter url
	@Test ---search test
	@AfterMethod ---logout from app
	
	@AfterClass ---closeBrowser
	@AfterTest ---deleteAllCookies
	PASSED: googleLogoTest
	PASSED: googleTitleTest
	PASSED: searchTest

	===============================================
    Default test
    Tests run: 3, Failures: 0, Skips: 0
	===============================================

	@AfterSuite ---generateTestReport

	===============================================
	Default suite
	Total tests run: 3, Passes: 3, Failures: 0, Skips: 0
	===============================================
	 * 
	 * 
	 */
	
	
	//Pre-Condition annotations -- starting with @Before keyword
	@BeforeSuite //1
	public void setup() {
	System.out.println("@BeforeSuite ---setup system property for chrome");	
	}
	
	@BeforeTest //2
	public void launchBrowser() {
		System.out.println("@BeforeTest ---launch chrome browser");
	
	}
		
	@BeforeClass //3
	public void login() {
		System.out.println("@BeforeClass ---login to app");
	}
	
	/*Execution sequence of different test cases:
	 * 
	 * @BeforeMethod
	 * @Test -1
	 * @After method
	 * 
	 * @BeforeMethod
	 * @Test - 2
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @Test - 3
	 * @AfterMethod
	 * 
	 */
	
		
	@BeforeMethod //4
	public void enterURL() {
		System.out.println("@BeforeMethod ---enter url");
	}
	
	//test cases -- starting with @Test keyword
	@Test //5
	public void googleTitleTest() {
		System.out.println("@Test ---Google title test");
	}
	
	@Test
	public void searchTest() {
		System.out.println("@Test ---search test");
	}
	
	@Test
	public void googleLogoTest() {
		System.out.println("@Test ---google logo test");
	}
	
	//post-conditions -- starting with @After keyword
	@AfterMethod //6
	public void logOut() {
		System.out.println("@AfterMethod ---logout from app");
	}
	
	@AfterClass //7
	public void closeBrowser() {
		System.out.println("@AfterClass ---closeBrowser");
	}
	
	@AfterTest //8
	public void deleteAllCookies() {
		System.out.println("@AfterTest ---deleteAllCookies");
	}
	
	@AfterSuite //9
	public void generateTestReport() {
		System.out.println("@AfterSuite ---generateTestReport");
	}
}
