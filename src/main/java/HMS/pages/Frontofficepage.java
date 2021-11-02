package HMS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HMS.base.testbase;

public class Frontofficepage extends testbase{
	
	
	
	@FindBy(css="h3.box-title")WebElement FOtable;
	@FindBy(css="div.box-tools>a:nth-child(2)")WebElement visitorbook;
      public Frontofficepage()
      {
    	  PageFactory.initElements(driver, this);
      }
      
      //Method for click visitorbook
      public String FOtabletitle()
      {
		return FOtable.getText();
    	  
      }
      public Visitorpage clickvisitorbook()
      {
    	  visitorbook.click();
		return new Visitorpage();
      }
      
      
      
      
      
      
}
