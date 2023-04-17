package orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminHomePage 
{

	@FindBy(linkText="Admin")
	WebElement admin;
	
	@FindBy(partialLinkText="Welcome")
	WebElement welcome;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	
	public boolean isAdminModuleDisplayed()
	{
		if(admin.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public void logout()
	{
		welcome.click();
		logout.click();
	}
	
	
	
}
