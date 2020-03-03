package com.olga.wikipedia.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    AppiumDriver driver;
    ArticleHelper articleHelper;
    SessionHelper sessionHelper;

    public void init() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "qa22");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/olgabasina/Documents/GitHub/HW_Mobile_OlgaBasin/src/test/resources/wikipedia2_7_5.apk");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        articleHelper = new ArticleHelper(driver);
        sessionHelper = new SessionHelper(driver);
    }

    public void stop() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public ArticleHelper getArticleHelper() {
        return articleHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
