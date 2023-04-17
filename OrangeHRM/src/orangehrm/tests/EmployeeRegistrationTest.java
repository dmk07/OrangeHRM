package orangehrm.tests;

import utils.AppUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.library.Employee;
import orangehrm.library.LoginPage;


public class EmployeeRegistrationTest extends AppUtils 
{

	@Test
	public void checkNewEmployeeReg() throws InterruptedException
	{
		LoginPage lp = new LoginPage();
		lp.adminLogin("Admin", "Qedge123!@#");
		
		Employee emp = new Employee();
		boolean res = emp.addEmployee("Leshant12345", "demo");
		Assert.assertTrue(res);
		lp.adminLogout();
		
	}
		

	

}
