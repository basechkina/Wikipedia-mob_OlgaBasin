package com.olga.wikipedia.tests;

import org.testng.annotations.Test;

public class DeleteArticleFromBookmarksTest extends TestBase {

    @Test
    public void testDeleteArticle() throws InterruptedException {

        app.getArticleHelper().openBookmarks();

        if (app.getArticleHelper().isBookmarkListEmpty()) {

            app.getArticleHelper().returnButton();
            app.getArticleHelper().exploreButton();
            app.getArticleHelper().addArticleToBookmark("Android");
            Thread.sleep(10000);
        }

        app.getArticleHelper().deleteArticle();
        Thread.sleep(10000);
    }
}
