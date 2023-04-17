package orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import orangehrm.library.AdminModuleConstants;
import orangehrm.library.User;
import utils.AppUtils;

public class UserRegTest extends AdminModuleConstants
{

	@Parameters({"role","ename","uname","pword"})
	@Test
	public void checkUserReg(String role,String ename,String uname,String pword) throws InterruptedException
	{
			User us = new User();
			boolean res = us.addUser(role, ename, uname, pword);
			Assert.assertTrue(res);		
	}	
	
}
