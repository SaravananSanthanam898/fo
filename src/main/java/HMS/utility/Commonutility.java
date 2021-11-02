package HMS.utility;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import HMS.base.testbase;

public class Commonutility extends testbase{
	
	
//Method for click on the upload box
	public static void clickuploadbutton(WebElement webE)
	{
		Actions actn=new Actions(driver);
		actn.click(webE).build().perform();
		
	}
	
//Method for upload file
	public static void uploadfile(String s)
	{
		StringSelection ssl=new StringSelection(s);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ssl, null);
		Robot rbt;
		
		try {
			rbt=new Robot();
			
			rbt.keyPress(KeyEvent.VK_ENTER);
			rbt.keyRelease(KeyEvent.VK_ENTER);
			rbt.keyPress(KeyEvent.VK_CONTROL);
			rbt.keyPress(KeyEvent.VK_V);
			rbt.keyRelease(KeyEvent.VK_CONTROL);
			rbt.keyRelease(KeyEvent.VK_V);
			rbt.keyPress(KeyEvent.VK_ENTER);
			rbt.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (AWTException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
//Screenshot on fail case
	public static void takescreenshot()
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		File destination=new File(currentDir+"./Screenshot/"+System.currentTimeMillis()+".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
