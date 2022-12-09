package org.example;

import net.thucydides.core.annotations.Steps;
import org.example.todoist.LoginPage;
import org.junit.jupiter.api.Test;

public class TodoistTests extends BaseSetup {

    @Steps
    LoginPage login;


    @Test
    public void userCanLogin() throws InterruptedException {
        login.openLoginPage();
        login.enterCredentials();
        login.waitForTodoistMainPage();
    }

}
