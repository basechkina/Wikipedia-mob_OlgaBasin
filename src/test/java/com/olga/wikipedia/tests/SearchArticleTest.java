package com.olga.wikipedia.tests;

import com.olga.wikipedia.model.Article;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchArticleTest extends TestBase {

    @Test
    public void testSearchArticle() throws InterruptedException {

        String articleName = "Android";
        app.getArticleHelper().searchArticle(new Article()
                .withArticleName(articleName));
        app.getArticleHelper().tapEnter();

        Assert.assertTrue(app.getArticleHelper().isArticlePresent(articleName));
    }

    @Test(enabled = false)
    public void testSearchArticleList() {
        String articleName = "Java";
        app.getArticleHelper().searchArticle(new Article()
                .withArticleName(articleName));

        Assert.assertTrue(app.getArticleHelper().isThereResult(20));

        app.getArticleHelper().swipeArticlesUp();
    }
}
