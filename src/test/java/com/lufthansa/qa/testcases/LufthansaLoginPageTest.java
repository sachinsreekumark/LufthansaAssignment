package com.lufthansa.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lufthansa.qa.pages.LufthansaHomePage;
import com.lufthansa.qa.pages.LufthansaLoginPage;
import com.lufthansa.qa.util.TestUtil;
import com.lufthansa.qa.base.TestBase;

public class LufthansaLoginPageTest extends TestBase {

	public LufthansaLoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	LufthansaHomePage LufthansaHomePage;
	LufthansaLoginPage LufthansaLoginPage;
	TestUtil TestUtil;
	
	
	@BeforeMethod
	  public void setup() throws IOException, InterruptedException 
	  {
		initialization();
		LufthansaLoginPage= new LufthansaLoginPage();
		TestUtil=new TestUtil();
	  
	  }
	
	
	@Test
	public void lufthansaLoginPageTitleTest()
	{
		String title=LufthansaLoginPage.validateLufthansaLoginPageTitle();
		Assert.assertEquals(title, "Login | Lufthansa");
	}
	
	

	
	
	@Test 
	public void lufthansaLogoTest()
	{
		boolean check=LufthansaLoginPage.validateLufthansaLogo();
		Assert.assertTrue(check);
	}
	
	@Test
	public void lufthansaLoginTest() throws IOException, InterruptedException
	{
		
		String message=LufthansaLoginPage.login();
		
		Assert.assertEquals(message, "You are not authorized to access this resource.");
			
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
