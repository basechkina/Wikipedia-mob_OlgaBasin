package com.olga.wikipedia.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {

    AppiumDriver driver;
    WebDriverWait wait;

    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void waitForElementAndTap(By locator, int timeOut) {
        wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            tap(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void tapEnter() throws InterruptedException {
        driver.getKeyboard().sendKeys(Keys.ENTER);
        pause(8000);
    }

    public void swipeUp() {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int stopY = (int) (size.height * 0.2);

        action.longPress(PointOption.point(x, startY))
                .moveTo(PointOption.point(x, stopY))
                .release()
                .perform();
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }
}
