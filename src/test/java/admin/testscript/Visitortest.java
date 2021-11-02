package admin.testscript;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HMS.base.testbase;
import HMS.pages.Dashboardpage;
import HMS.pages.Frontofficepage;
import HMS.pages.LoginPage;
import HMS.pages.Visitorpage;
import HMS.utility.ReadExcel;

public class Visitortest extends testbase{
	
	LoginPage logobj;
	Dashboardpage dashobj;
	Frontofficepage FOobj;
	Visitorpage visobj;

	public Visitortest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		logobj=new LoginPage();
		dashobj=logobj.login(prop.getProperty("USERNAME"),prop.getProperty("PASSWORD"));
		FOobj=dashobj.frontofficeclick();
		visobj=FOobj.clickvisitorbook();
	}
	
	@DataProvider
	public Object[][] exceldata()
	{
		Object[][] data=ReadExcel.getTestData("Add visitor Details");
		return data;
		
	}
	

    @Test(dataProvider ="exceldata" )
    
    public void visitorbooktest(String args[]) throws InterruptedException 
    {
    	String expectedvisitortitle="Visitor List";
    	Assert.assertEquals(visobj.verifyvisitortitle(), expectedvisitortitle);
    	visobj.clickaddvisitor();
    	String expectedaddvisitortitle="Add Visitor";
    	Assert.assertEquals(visobj.verifyaddvisitortitle(), expectedaddvisitortitle);
    	visobj.enteralldetailsinaddvisitor(args);
    	
    }
    @AfterMethod
    public void teardown()
    {
    	driver.close();
    }
    
    
    
    
    
    
    
    
}
