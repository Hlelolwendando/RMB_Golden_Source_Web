package com.rmb.golden.source.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
    //ScreenShot,alerts,windows,javascript executer
    static WebDriverWait webDriverWait;
    static WebDriver driver;
    public static void waitUntilElementElementVisible(WebElement webElement){
        try{
            webDriverWait = new WebDriverWait(driver,20);
            WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((By) webElement));
        }
        catch (Exception e){

        }
    }
    public static String grabScreenShot(WebDriver webDriver){
        File FileScreenShot = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        String screenShotPath = System.getProperty("user.dir")+ "./ScreenShots/RMB_GoldenSource_"+ getCurrentDate() +".png";
        try {
            FileHandler.copy(FileScreenShot , new File(screenShotPath));
        } catch (IOException e) {
            System.out.println("Unable to grab screen shot" + e.getMessage());
        }
        return  screenShotPath;
    }
    public static String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentDate = new Date();
        return  dateFormat.format(currentDate);
    }
}
