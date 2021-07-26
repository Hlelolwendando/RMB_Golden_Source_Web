package com.rmb.golden.source.webpages;

import com.rmb.golden.source.utilities.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.rmb.golden.source.utilities.Helper.waitUntilElementElementVisible;

public class LoginWebLocators {
    WebDriver driver;

    public LoginWebLocators(WebDriver driver){
        this.driver=driver;
    }
    @FindBy(id="user_email_login")  WebElement username;
    @FindBy(id ="user_password") WebElement password;
    @FindBy(id = "accept-cookie-notification") WebElement cookieBtn;
    @FindBy(id = "user_submit") WebElement loginButton;

    public  void LoginTest(String userName,String passWord) throws InterruptedException {
        waitUntilElementElementVisible(username);
        username.sendKeys(userName);
        password.sendKeys(passWord);
        waitUntilElementElementVisible(cookieBtn);
        cookieBtn.click();
        waitUntilElementElementVisible(loginButton);
        loginButton.click();
    }
}

