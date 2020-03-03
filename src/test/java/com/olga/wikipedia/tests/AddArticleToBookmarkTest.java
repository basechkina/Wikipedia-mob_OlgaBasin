package com.olga.wikipedia.tests;

import com.olga.wikipedia.model.Article;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddArticleToBookmarkTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getSessionHelper().isSkipButtonPresent()) {
            app.getSessionHelper().skipButton();
        }
    }

    @Test
    public void testAddArticleToBookMark() throws InterruptedException {
        app.getArticleHelper().searchArticle(new Article()
                .withArticleName("Android"));
        app.getArticleHelper().tapEnter();
        app.getArticleHelper().bookmarkButton();
        app.getArticleHelper().gotItButton();
        app.getArticleHelper().addToSaved();
//        app.getArticleHelper().viewList();
    }
}
