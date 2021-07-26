package com.rmb.golden.source.testcases;
import com.rmb.golden.source.utilities.DataProviderConfig;
import com.rmb.golden.source.webpages.BaseClass;
import com.rmb.golden.source.webpages.LoginWebLocators;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


import org.testng.annotations.Test;

import static com.rmb.golden.source.utilities.TestConstants.*;


public class LoginDelegate extends BaseClass {
    private static Logger log = LoggerFactory.getLogger(LoginDelegate.class);
    private String username;
    private String password;

    @Test
    public  void LoginTest() throws InterruptedException {

        username = dataProviderConfig.getDataFromConfig(TEST_SERVICE_ACCOUNT_USERNAME_KEY);
        password = dataProviderConfig.getDataFromConfig(TEST_SERVICE_ACCOUNT_PASSWORD_KEY);
        log.info("Redirecting the user to Login Page");
        logger = extentReports.createTest("Login to RMB Site");
        LoginWebLocators loginWebLocators =PageFactory.initElements(driver,LoginWebLocators.class);
        logger.info("Starting the Application...");
        loginWebLocators.LoginTest(username,password);
    }
}
