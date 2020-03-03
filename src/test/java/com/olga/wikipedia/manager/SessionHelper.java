package com.olga.wikipedia.manager;

import com.olga.wikipedia.model.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SessionHelper extends HelperBase {
    public SessionHelper(AppiumDriver driver) {
        super(driver);
    }

    public void skipButton() {
        tap(By.id("fragment_onboarding_skip_button"));
    }

    public boolean isSkipButtonPresent() {
        return isElementPresent(By.id("fragment_onboarding_skip_button"));
    }

    public void logInButton() {
        waitForElementAndTap(By.xpath("//*[@resource-id='org.wikipedia:id/view_announcement_action_positive']"), 20);
    }

    public void fillLoginForm(User user) {
        type(By.xpath("//android.widget.EditText[@text='Username']"), user.getUserName());
        type(By.xpath("//android.widget.EditText[@text='Password']"), user.getPassword());
    }

    public void confirmLogin() {
        tap(By.xpath("//*[@resource-id ='org.wikipedia:id/login_button']"));
    }

    public void returnToHomepage() {
        tap(By.xpath("//*[@class='android.widget.ImageButton']"));
    }
}
