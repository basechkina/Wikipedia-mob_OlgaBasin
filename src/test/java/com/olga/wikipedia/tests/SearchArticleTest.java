package com.olga.wikipedia.tests;

import com.olga.wikipedia.model.Article;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchArticleTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getArticleHelper().isSkipButtonPresent()) {
            app.getArticleHelper().skipButton();
        }
    }

    @Test
    public void searchArticleTest() throws InterruptedException {

        app.getArticleHelper().tapOnSearchField();
        app.getArticleHelper().searchArticle(new Article()
                .withArticleName("Android"));

    }
}
