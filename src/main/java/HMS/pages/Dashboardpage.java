package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HMS.base.testbase;
public class Dashboardpage extends  testbase{
	
    @FindBy(css="img.topuser-image")WebElement clickprofile;
    @FindBy(xpath="//*[text()='Super Admin']")WebElement cheksuperadmin;
    @FindBy(css="i.fa-sign-out")WebElement clickonlogout;
    @FindBy(css="ul.sidebar-menu>li:nth-child(1)")WebElement clickfrontoffice;

	public Dashboardpage()
	{
		PageFactory.initElements(driver, this);
	}
	
//Method for signout the dashboard page
	public void clickonprofile()
	{
		clickprofile.click();
	}
	public String superadmintext()
	{
		waitforvisibility(cheksuperadmin);
		return cheksuperadmin.getText();
		
	}
	public void clicklogoutbutton()
	{
		clickonlogout.click();
	}
	public Frontofficepage frontofficeclick()
	{
		clickfrontoffice.click();
		return new Frontofficepage();
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
