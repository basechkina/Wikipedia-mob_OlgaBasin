package com.olga.wikipedia.tests;

import com.olga.wikipedia.model.Article;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchArticleTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getSessionHelper().isSkipButtonPresent()) {
            app.getSessionHelper().skipButton();
        }
    }

    @Test
    public void testSearchArticle()  {

        app.getArticleHelper().searchArticle(new Article()
                .withArticleName("Android"));

        Assert.assertTrue(app.getArticleHelper().isThereResult(20));

        app.getArticleHelper().swipeArticlesUp();
    }
}
