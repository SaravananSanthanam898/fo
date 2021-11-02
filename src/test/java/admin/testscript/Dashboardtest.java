package admin.testscript;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import HMS.base.testbase;
import HMS.pages.Dashboardpage;
import HMS.pages.LoginPage;

public class Dashboardtest extends testbase{
	Dashboardpage dashobj;	
	LoginPage logobj;
	public Dashboardtest()
	{
		super();
	}
	
	@BeforeClass
	public void setup()
	{
		initialization();
	    logobj=new LoginPage();
	    dashobj=logobj.login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
     }
	@Test
	public void dashboardtest()
	{
		dashobj.clickonprofile();
		String expectedadminname="Super Admin";
		Assert.assertEquals(dashobj.superadmintext(), expectedadminname);
		dashobj.clicklogoutbutton();
	}
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
	
	

}
