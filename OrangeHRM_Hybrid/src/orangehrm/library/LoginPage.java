package orangehrm.library;

import org.openqa.selenium.By;

import utils.AppUtils;

public class LoginPage extends AppUtils
{

	public boolean adminLogin(String uid,String pwd)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uid);
		driver.findElement(By.name("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
		if(driver.findElement(By.linkText("Admin")).isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
		
		
	}
	
	public boolean Logout()
	{
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.partialLinkText("Logout")).click();
		if(driver.findElement(By.id("btnLogin")).isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean empLogin(String uid,String pwd)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uid);
		driver.findElement(By.name("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
		try 
		{
			driver.findElement(By.linkText("Admin"));
			return false;
			
		} catch (Exception e) 
		{
			return true;
		}
	}
	
	
}
