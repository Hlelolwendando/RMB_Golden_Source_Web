package com.rmb.golden.source.webpages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.rmb.golden.source.utilities.BrowserConfig;
import com.rmb.golden.source.utilities.DataProviderConfig;
import com.rmb.golden.source.utilities.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseClass {
    public WebDriver driver;
    public DataProviderConfig dataProviderConfig;
    public ExtentReports extentReports;
    public ExtentTest logger;

    @BeforeSuite
    public void setUpSuite() {
       dataProviderConfig = new DataProviderConfig();
       ExtentSparkReporter reporter = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/RMB_Golden_Source_"+Helper.getCurrentDate()+".html"));
       extentReports = new ExtentReports();
       extentReports.attachReporter(reporter);
    }
    @BeforeClass
    public void setUp() throws InterruptedException {
        driver = BrowserConfig.InitApplication(driver,dataProviderConfig.getBrowser(),dataProviderConfig.getStringURL());
        //driver = BrowserConfig.InitApplication(driver,dataProviderConfig.getFireFoxBrowser(),dataProviderConfig.getStringURL());
    }
    @AfterClass
    public void tearDown(){
        BrowserConfig.CloseBrowser(driver);
    }
    @AfterMethod
    public  void tearDownMethod(ITestResult iTestResult){
        if (iTestResult.getStatus() == ITestResult.FAILURE)
        {
            logger.fail("Test Case Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.grabScreenShot(driver)).build());
        }
        else if(iTestResult.getStatus() == ITestResult.SUCCESS){
            logger.pass("Test Case Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.grabScreenShot(driver)).build());
        }
        extentReports.flush();
    }
}
