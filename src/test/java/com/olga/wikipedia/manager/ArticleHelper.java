package com.olga.wikipedia.manager;

import com.olga.wikipedia.model.Article;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    public boolean isArticlePresent(String articleName) {
        String articleXpath = "//*[contains(@text,'" + articleName + "')]";
        return isElementPresent(By.xpath(articleXpath));
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
        tap(By.xpath("//*[@content-desc ='Add this article to a reading list']"));
        waitForElementAndTap(By.xpath("//*[@content-desc ='Add this article to a reading list']"), 10);
    }

    public void gotItButton() {
        tap(By.xpath("//*[@resource-id='org.wikipedia:id/onboarding_button']"));
    }


    public void addToSaved() {
        waitForElementAndTap(By.xpath("//*[@resource-id = 'org.wikipedia:id/default_list_empty_image']"), 10);
    }

    public void viewList() {
        tap(By.xpath("//*[@resource-id ='org.wikipedia:id/snackbar_action']"));
    }

    public void openBookmarks() {
        waitForElementAndTap(By.xpath("//*[@content-desc='My lists']"), 10);
        waitForElementAndTap(By.xpath("//*[@resource-id='org.wikipedia:id/reading_list_list']"), 10);
    }

    public boolean isBookmarkListEmpty() {
        return isElementPresent(By.xpath("//*[@resource-id='org.wikipedia:id/reading_list_empty_text']"));
    }

    public void returnButton() {
        tap(By.xpath("//*[@content-desc='Navigate up']"));
    }

    public void exploreButton() {
        tap(By.xpath("//*[@content-desc='Explore']"));
    }

    public void addArticleToBookmark(String articleName) throws InterruptedException {
        searchArticle(new Article()
                .withArticleName(articleName));
        tapEnter();
        bookmarkButton();
        gotItButton();
        addToSaved();
        viewList();
    }

    public void deleteArticle() {
        swipeElementToLeft(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description']"));
    }

    public void swipeElementToLeft(By locator) {

        TouchAction action = new TouchAction(driver);

        WebElement element = driver.findElement(locator);
        int leftX = element.getLocation().getX();
        int rightX = leftX + element.getSize().getWidth();

        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();

        int middleY = (upperY + lowerY) / 2;

        action.longPress(PointOption.point(rightX, middleY))
                .moveTo(PointOption.point(leftX, middleY))
                .release()
                .perform();
    }
}

