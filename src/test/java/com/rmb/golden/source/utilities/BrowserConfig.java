package com.rmb.golden.source.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserConfig {
    public static WebDriver InitApplication(WebDriver driver, String browserName, String URL) {
        if (browserName.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals(("Firefox"))) {
            System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equals("Edge")) {
            System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("Browser Not Supported");
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver;
    }

    public static void CloseBrowser(WebDriver driver) {
        driver.quit();
    }

}
