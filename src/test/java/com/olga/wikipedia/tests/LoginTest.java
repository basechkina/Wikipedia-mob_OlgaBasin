package com.olga.wikipedia.tests;

import com.olga.wikipedia.model.User;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


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
