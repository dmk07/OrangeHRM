package orangehrm.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import orangehrm.library.Employee;
import orangehrm.library.LoginPage;
import orangehrm.library.User;
import utils.AppUtils;
import utils.XLUtils;

public class OrangeHRM_HybridTest extends AppUtils 
{

	@Test
	public void orangeHRMTestSuite() throws IOException, InterruptedException
	{
		
		LoginPage lp = new LoginPage();		
		Employee emp = new Employee();
		User us = new User();
		
		String keywordfile = "C:\\Selenium_1130\\OrangeHRM_Hybrid\\keywordfiles\\OrangeHRMKeywords.xlsx";
		String tcsheet = "TestCases";
		String tssheet = "TestSteps";
		
		int tccount = XLUtils.getRowCount(keywordfile, tcsheet);
		int tscount = XLUtils.getRowCount(keywordfile, tssheet);
		String tcid,tcexeflag,tstcid,keyword,tsresult,tcresult;
		
		String adminuid,adminpwd;
		String firstname,lastname;
		String role,empname,empuid,emppwd;
		boolean res = false;
		
		for(int i=1;i<=tccount;i++)
		{
			tcid = XLUtils.getStringCellData(keywordfile, tcsheet, i, 0);
			tcexeflag = XLUtils.getStringCellData(keywordfile, tcsheet, i, 2);
			if(tcexeflag.equalsIgnoreCase("y"))
			{
				for(int j=1;j<=tscount;j++)
				{
					tstcid = XLUtils.getStringCellData(keywordfile, tssheet, j, 0);
					if(tstcid.equalsIgnoreCase(tcid))
					{
						keyword = XLUtils.getStringCellData(keywordfile, tssheet, j, 4);
						switch (keyword.toLowerCase()) 
						{
						case "adminlogin":
							adminuid = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
							adminpwd = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
							 res = lp.adminLogin(adminuid, adminpwd);							 
							break;
						case "adminlogout":
							res = lp.Logout();
							break;
						case "newempreg":
							firstname = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
							lastname = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
							res = emp.addEmployee(firstname, lastname);
							break;
						case "newuserreg":
							role = XLUtils.getStringCellData(keywordfile, tssheet, j, 5);
							empname = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
							empuid = XLUtils.getStringCellData(keywordfile, tssheet, j, 7);
							emppwd = XLUtils.getStringCellData(keywordfile, tssheet, j, 8);
							res = us.addUser(role, empname, empuid, emppwd);
							break;
						case "emplogin":
							empuid = XLUtils.getStringCellData(keywordfile, tssheet, j,5);
							emppwd = XLUtils.getStringCellData(keywordfile, tssheet, j, 6);
							res = lp.empLogin(empuid, emppwd);
							break;
						case "emplogout":
							res = lp.Logout();
							break;
							
						}		
						//Code to update Test Step Result
						if(res)
						{
							tsresult = "Pass";
							XLUtils.setCellData(keywordfile, tssheet, j, 3, tsresult);
							XLUtils.fillGreenColor(keywordfile, tssheet, j, 3);
						}else
						{
							tsresult = "Fail";
							XLUtils.setCellData(keywordfile, tssheet, j, 3, tsresult);
							XLUtils.fillRedColor(keywordfile, tssheet, j, 3);
						}
					
						//Code to update TestCase Result
						tcresult = XLUtils.getStringCellData(keywordfile, tcsheet, i, 3);
						if(!tcresult.equalsIgnoreCase("fail"))
						{
							XLUtils.setCellData(keywordfile, tcsheet, i, 3, tsresult);
						}
						
						// code to fill TCTesult Colora=s
						tcresult = XLUtils.getStringCellData(keywordfile, tcsheet, i, 3);
						if(tcresult.equalsIgnoreCase("pass"))
						{
							XLUtils.fillGreenColor(keywordfile, tcsheet, i, 3);
						}else
						{
							XLUtils.fillRedColor(keywordfile, tcsheet, i, 3);
						}
						
					}
				}
			}else
			{
				XLUtils.setCellData(keywordfile, tcsheet, i, 3, "Blocked");
				XLUtils.fillRedColor(keywordfile, tcsheet, i, 3);
			}
		}
	}
	
	
}
