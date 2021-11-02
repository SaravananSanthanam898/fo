package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import HMS.base.testbase;
import HMS.utility.Commonutility;
import HMS.utility.Datepicker;



public class Visitorpage extends testbase{
	
	
	@FindBy(css="div.box-header>h3.box-title")WebElement checkvisitortitle;
	@FindBy(css="div.box-tools")WebElement clickaddvisitor;
	@FindBy(xpath="//h4[contains(text(),'Add Visitor')]")WebElement checkaddvisitortitle;
	@FindBy(css="form#formadd select[name='purpose']")WebElement clickdropdownpurpose;
	@FindBy(css="form#formadd input[name='name']")WebElement entername;
	@FindBy(css="form#formadd input[name='contact']")WebElement enterphone;
	@FindBy(css="form#formadd input[name='id_proof']")WebElement enteridcard;
	@FindBy(css="form#formadd input[name='pepples']")WebElement enterNoofperson;
	@FindBy(css="form#formadd input[name='date']")WebElement datepicker;
	@FindBy(css="form#formadd textarea[name='note']")WebElement enternote;
	@FindBy(css="form#formadd input[name='file']")WebElement fileupload;
	@FindBy(css="button.clse")WebElement clickonclosebutton;
	
	
    public Visitorpage()
	{
		PageFactory.initElements(driver, this);
	}
    
    
    public String verifyvisitortitle()
    {
		return checkvisitortitle.getText();
    	
    }
    public void clickaddvisitor()
    {
    	clickaddvisitor.click();
    }
    public String verifyaddvisitortitle()
    {
    	waitforvisibility(checkaddvisitortitle);
		return checkaddvisitortitle.getText();
    	
    }
    public void enteralldetailsinaddvisitor(String data[]) throws InterruptedException 
    {
    	Select sl=new Select(clickdropdownpurpose);
    	sl.selectByVisibleText(data[0]);
    	entername.sendKeys(data[1]);
    	enterphone.sendKeys(data[2]);
    	enteridcard.sendKeys(data[3]);
    	enterNoofperson.sendKeys(data[4]);
    	datepicker.click();
    	Datepicker dp=new Datepicker();
    	dp.datpicker(data[5]);
    	enternote.sendKeys(data[6]);
    	//fileupload
    	Commonutility.clickuploadbutton(fileupload);
    	Thread.sleep(6000);
    	Commonutility.uploadfile(data[7]);
    	Thread.sleep(6000);
    	clickonclosebutton.click();
    	
    }
    
	

}
