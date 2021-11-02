package admin.testscript;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HMS.base.testbase;
import HMS.pages.LoginPage;

public class LoginTest extends testbase{
	
	LoginPage logobj;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		logobj=new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginstep1()
	{
	   String expectedtitle="Smart Hospital : Hospital Management System";
	   Assert.assertEquals(logobj.pagetitle(), expectedtitle);
	   Assert.assertTrue(logobj.logotest(), expectedtitle);
	   String ecpectedformtitle="Admin Login";
	   Assert.assertEquals(logobj.formtitle(), ecpectedformtitle);
	   logobj.login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
	}
	
	@Test(priority=2)
	public void forgotloginstep2()
	{
		logobj.forpass();
		Assert.assertTrue(logobj.forlogo());	
		logobj.enteremail(prop.getProperty("EMAIL"));
		String expextedogname="Please check your email to recover your password";
		Assert.assertEquals(logobj.alert(), expextedogname);
		logobj.unamepasssignin(prop.getProperty("OGUSERNAME"), prop.getProperty("OGPASSWORD"));
		
     }
	@Test(priority=3)
	public void adminloginstep3()
	{
		logobj.againclickforgot();
		Assert.assertTrue(logobj.key());
		logobj.clickadminlogin();
		Assert.assertTrue(logobj.againcheckkey());
		logobj.typeunamepasswrdclksignin(prop.getProperty("OGUSERNAME"), prop.getProperty("OGPASSWORD"));
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	   
	   
	
	
	
	
	
	
	
	

}
