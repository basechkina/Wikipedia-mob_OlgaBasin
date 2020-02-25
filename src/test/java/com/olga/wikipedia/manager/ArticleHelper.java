package com.olga.wikipedia.manager;

import com.olga.wikipedia.model.Article;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ArticleHelper extends HelperBase {

    public ArticleHelper(AppiumDriver driver) {
        super(driver);
    }

    public void tapOnSearchField() throws InterruptedException {
        pause(3000);
        tap(By.id("search_container"));
    }

    public void searchArticle(Article article) throws InterruptedException {
        pause(3000);
        type(By.id("search_src_text"), article.getArticleName());
        tap(By.id("search_src_text"));
        driver.getKeyboard().sendKeys(Keys.ENTER);
        pause(3000);
    }

    public void skipButton() {
        tap(By.id("fragment_onboarding_skip_button"));
    }

    public boolean isSkipButtonPresent() {
        return isElementPresent(By.id("fragment_onboarding_skip_button"));
    }
}
