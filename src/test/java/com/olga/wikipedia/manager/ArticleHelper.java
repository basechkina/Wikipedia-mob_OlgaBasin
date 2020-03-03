package com.olga.wikipedia.manager;

import com.olga.wikipedia.model.Article;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArticleHelper extends HelperBase {

    public ArticleHelper(AppiumDriver driver) {
        super(driver);
    }

    public void tapOnSearchField() {
        tap(By.id("search_container"));
    }

    public void searchArticle(Article article) {
        tapOnSearchField();
        type(By.id("search_src_text"), article.getArticleName());
        tap(By.id("search_src_text"));
    }

    public void swipeArticlesUp() {
        hideKeyboard();
        swipeUp();
    }

    public boolean isThereResult(int timeout) {
        new WebDriverWait(driver, timeout).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']")));

        return isElementPresent(By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']"));
    }

    public void bookmarkButton() {
        waitForElementAndTap(By.xpath("//android.widget.ImageView[@resource-id='org.wikipedia:id/article_menu_bookmark']"), 10);
        tap(By.xpath("//android.widget.ImageView[@resource-id='org.wikipedia:id/article_menu_bookmark']"));
    }

    public void gotItButton() {
        tap(By.xpath("//*[@resource-id='org.wikipedia:id/onboarding_button']"));
    }


    public void addToSaved() {
        tap(By.xpath("//*[@class='android.view.ViewGroup']"));
    }

    public void viewList() {
        tap(By.xpath("//android.widget.ImageView[@resource-id='org.wikipedia:id/article_menu_bookmark']"));
    }
}
