package com.olga.wikipedia.tests;

import com.olga.wikipedia.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.getSessionHelper().isSkipButtonPresent()) {
            app.getSessionHelper().skipButton();
        }
    }

    @Test
    public void testLogIn() {
        app.getSessionHelper().logInButton();
        app.getSessionHelper().fillLoginForm(new User()
                .withUserName("olgatester22")
                .withPassword("gmail12358"));
        app.getSessionHelper().confirmLogin();
        app.getSessionHelper().returnToHomepage();

    }
}
