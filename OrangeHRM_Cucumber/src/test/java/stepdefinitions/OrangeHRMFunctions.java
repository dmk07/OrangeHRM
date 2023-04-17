package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMFunctions 
{
	public static WebDriver driver;
	
	@Given("^I open browser with url \"([^\"]*)\"$")
	public void launchApp(String url) 
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);			
	}

	@Then("^I should see login page$")
	public void i_should_see_login_page() 
	{
		if (driver.findElement(By.id("btnLogin")).isDisplayed()) 
		   {
			   System.out.println("Application Launched Successfully");
		} else 
		{
			System.out.println("Application Launch Failed");
		}
	}

	@When("^I enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String uname) 
	{
	    driver.findElement(By.id("txtUsername")).sendKeys(uname);
	}

	@When("^I enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String pword)  
	{
		driver.findElement(By.id("txtPassword")).sendKeys(pword);
	}

	@When("^i click login$")
	public void i_click_login()
	{
		driver.findElement(By.id("btnLogin")).click();
	}

	@Then("^I should see admin module$")
	public void i_should_see_admin_module() throws Throwable 
	{
		if (driver.findElement(By.linkText("Admin")).isDisplayed()) 
	    {
	    	System.out.println("Admin Login Successful");
		} else 
		{
			System.out.println("Admin Login Failed");
		}
	}
	
	@When("^i click logout$")
	public void i_click_logout() 
	{
	    driver.findElement(By.partialLinkText("Welcome")).click();
	    driver.findElement(By.partialLinkText("Logout")).click();
	}

	@When("^I close browser$")
	public void i_close_browser() 
	{
	    driver.close();
	}
	
	@Then("^I should see error message$")
	public void i_should_see_error_message() 
	{
		String errmsg = driver.findElement(By.id("spanMessage")).getText();
		if(errmsg.toLowerCase().contains("invalid"))
		{
			System.out.println("Login Failed for invalid data");
		}
	}
	@When("^I click pim and add employee$")
	public void i_click_pim_and_add_employee()  
	{
	    driver.findElement(By.linkText("PIM")).click();
	    driver.findElement(By.linkText("Add Employee")).click();
	}

	@Then("^I should see new employee registration page$")
	public void i_should_see_new_employee_registration_page() 
	{
		String expurl = "addemployee";
		String acturl = driver.getCurrentUrl().toLowerCase();
		if(acturl.contains(expurl))
		{
			System.out.println("System displayed New Employee Registration Page");
		}
	}

	@When("^I enter firstname as \"([^\"]*)\"$")
	public void i_enter_firstname_as(String fname) 
	{
		driver.findElement(By.id("firstName")).sendKeys(fname);
	}

	@When("^I enter lastname as \"([^\"]*)\"$")
	public void i_enter_lastname_as(String lname) 
	{
		driver.findElement(By.id("lastName")).sendKeys(lname);
	}

	@When("^I click Save$")
	public void i_click_Save() throws Throwable 
	{
		driver.findElement(By.id("btnSave")).click();
	}
	
}
