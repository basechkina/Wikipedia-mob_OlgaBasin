package com.olga.wikipedia.tests;

import com.olga.wikipedia.model.Article;
import org.testng.annotations.Test;

public class AddArticleToBookmarkTest extends TestBase {


    @Test
    public void testAddArticleToBookmark() throws InterruptedException {

        String articleName = "Android";
        app.getArticleHelper().searchArticle(new Article()
                .withArticleName(articleName));
        app.getArticleHelper().tapEnter();
        app.getArticleHelper().bookmarkButton();
        app.getArticleHelper().gotItButton();
        app.getArticleHelper().addToSaved();
        app.getArticleHelper().viewList();
    }
}
