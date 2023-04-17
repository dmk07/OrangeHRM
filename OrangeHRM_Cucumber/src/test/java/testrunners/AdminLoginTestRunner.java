package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles/login.feature",glue="stepdefinitions",dryRun=false,
plugin={"com.cucumber.listener.ExtentCucumberFormatter:Reports/LoginTestReport.html"},
tags=("@tag1,@tag2"))
public class AdminLoginTestRunner extends AbstractTestNGCucumberTests 
{

}
