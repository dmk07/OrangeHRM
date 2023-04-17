package orangehrm.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.library.LoginPage;
import utils.AppUtils;
import utils.XLUtils;

public class AdminLoginTestwithValidData extends AppUtils 
{

	
	@Test
	public void checkAdminLogin() throws IOException
	{
		String datafile = "C:\\Selenium_1130\\OrangeHRMDDT\\testdatafiles\\TestData.xlsx";
		String datasheet = "LoginValidData";		
		String uname,pword;		
		LoginPage lp = new LoginPage();
		
		int rowcount = XLUtils.getRowCount(datafile, datasheet);
		for(int i=1;i<=rowcount;i++)
		{
			uname = XLUtils.getStringCellData(datafile, datasheet, i, 0);
			pword = XLUtils.getStringCellData(datafile, datasheet, i, 1);
			boolean res = lp.adminLoginforValidData(uname, pword);
			Assert.assertTrue(res);
			if(res)
			{
				XLUtils.setCellData(datafile, datasheet, i, 2, "Pass");
				XLUtils.fillGreenColor(datafile, datasheet, i, 2);
			}else
			{
				XLUtils.setCellData(datafile, datasheet, i, 2, "Fail");
				XLUtils.fillRedColor(datafile, datasheet, i, 2);
			}
			lp.Logout();
			
			File srcfile = new File(datafile);
			File destfile = new File("C:\\Selenium_1130\\OrangeHRMDDT\\results\\TestResults.xlsx");
			FileUtils.copyFile(srcfile, destfile);
		}
		
		
	}
	
	
	
	
	
}
