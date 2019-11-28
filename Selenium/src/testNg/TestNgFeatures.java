package testNg;

import org.testng.annotations.*;

public class TestNgFeatures {

	@Test
	public void loginTest() {
		System.out.println("login test");
		int i=9/0;
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void HomePageTest() {
		System.out.println("HomePage test");
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void SearchPageTest() {
		System.out.println("Search page test");
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void RegPageTest() {
		System.out.println("Reg page test");
	}
	
	
	
	
	
	
	
	
	
	
}
