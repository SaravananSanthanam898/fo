package admin.testscript;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import HMS.base.testbase;
import HMS.pages.Dashboardpage;
import HMS.pages.Frontofficepage;
import HMS.pages.LoginPage;

public class Fronofficetest extends testbase{
	LoginPage logobj;
	Dashboardpage dashobj;
	Frontofficepage FOobj;
	public Fronofficetest()
	{
		super();
	}
	@BeforeClass
	public void setup()
	{
		initialization();
		logobj=new LoginPage();
		dashobj=logobj.login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		FOobj=dashobj.frontofficeclick();
	}
	@Test
	public void frontofficetest()
	{
		String expectedfotitlename="Appointment Details";
		Assert.assertEquals(FOobj.FOtabletitle(), expectedfotitlename);
		FOobj.clickvisitorbook();
	}
	
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
	
	

}
