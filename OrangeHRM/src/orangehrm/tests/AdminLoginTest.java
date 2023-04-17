package orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.library.LoginPage;
import utils.AppUtils;

public class AdminLoginTest extends AppUtils
{

	@Test
	public void checkAdminLogin()
	{
		LoginPage lp=new LoginPage();
		boolean res = lp.adminLogin("Admin", "Qedge123!@#");
		Assert.assertTrue(res);
		lp.adminLogout();
	}
	
	

}
