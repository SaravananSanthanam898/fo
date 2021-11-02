package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HMS.base.testbase;

public class LoginPage extends testbase{
	
//WebElement
	
	@FindBy(css="div.form-top-left>img")WebElement logo;
	@FindBy(css="h3.font-white")WebElement formname;
	@FindBy(css="input.form-username")WebElement username;
	@FindBy(css="input.form-password")WebElement password;
	@FindBy(css="button.btn")WebElement signin;
	@FindBy(css="a.forgot")WebElement forgotpassword;
	@FindBy(css="img.logowidth")WebElement forgotlogo;
	@FindBy(name="email")WebElement emailid;
	@FindBy(css="button.btn")WebElement submitclick;
	@FindBy(css="div.alert-success")WebElement alertmsg;
	@FindBy(css="input.form-username")WebElement ogusername;
	@FindBy(css="input#password")WebElement ogpassword;
	@FindBy(css="button.btn")WebElement clicksignin;
	@FindBy(css="a.forgot")WebElement clickagainforgot;
	@FindBy(css="i.fa-key")WebElement findkey;
	@FindBy(css="a[class='forgot']")WebElement adminclick;
	@FindBy(css="i.fa-key")WebElement againkeytest;
	
//Create constructor for this class
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
//Method For getting page title
	
	public String pagetitle()
	{
		return driver.getTitle();
		
	}
//Method for Logo Name
	public boolean logotest()
	{
		return logo.isDisplayed();
		
	}
//Method for formname text
	public String formtitle()
	{
		return formname.getText();
		
	}
	
//Method for username,password and signin button 
	public Dashboardpage login(String uname,String pass)
	{
		username.sendKeys(uname);;
		password.sendKeys(pass);
		signin.click();
		return new Dashboardpage();
	}	
		
//Method for forgot password
	public void forpass()
	{
		forgotpassword.click();
	}
//Method for forgot password page
	public boolean forlogo()
	{
		return forgotlogo.isDisplayed();
		
		
	}
//Method for enter email id		
	public void enteremail(String gmail)
	{
		emailid.sendKeys(gmail);
		submitclick.click();
		
	}
//Method for enter again the username ,password and click signin button
	public String alert()
	{
		return alertmsg.getText();
		
	}
    public void unamepasssignin(String oguname,String ogpasswrd)
    {
    	ogusername.sendKeys(oguname);
    	ogpassword.sendKeys(ogpasswrd);
    	clicksignin.click();
    }
//Method for click on the admin login 
    public void againclickforgot()
    {
    	clickagainforgot.click();
    	
    }
    public boolean key()
    {
		return findkey.isDisplayed();
    	
    }
	public void clickadminlogin()
	{
		adminclick.click();
	}
	
//Method for again enter the username,password and click signin button	
	public boolean againcheckkey()
	{
		return againkeytest.isDisplayed();
		
	}
	public void typeunamepasswrdclksignin(String name,String paswod)
	{
		ogusername.sendKeys(name);
		ogpassword.sendKeys(paswod);
		clicksignin.click();
		
	}
	
	
}
