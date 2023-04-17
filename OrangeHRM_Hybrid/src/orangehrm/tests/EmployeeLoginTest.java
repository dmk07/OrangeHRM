package orangehrm.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import orangehrm.library.LoginPage;
import utils.AppUtils;

public class EmployeeLoginTest extends AppUtils
{
	
	@Parameters({"uid","pwd"})
	@Test
	public void checkEmpLogin(String uid,String pwd)
	{
		LoginPage lp = new LoginPage();
		lp.empLogin(uid, pwd);
		lp.Logout();
	}
	
	
	
}
