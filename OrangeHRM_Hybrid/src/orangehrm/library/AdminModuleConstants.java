package orangehrm.library;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utils.AppUtils;

public class AdminModuleConstants extends AppUtils 
{

	@Parameters({"adminuname","adminpword"})
	@BeforeTest
	public void adminLogin(String uid,String pwd)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uid);
		driver.findElement(By.name("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@AfterTest
	public void adminLogout()
	{
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.partialLinkText("Logout")).click();
	}
	
}
