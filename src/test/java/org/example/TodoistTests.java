package org.example;

import net.thucydides.core.annotations.Steps;
import org.example.todoist.LoginPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.Cookie;

@Execution(ExecutionMode.SAME_THREAD)
public class TodoistTests extends BaseSetup {

    @Steps
    LoginPage login;

    private static Cookie authCookie;

    @Test
    public void userCanLogin() throws InterruptedException {
        login.openLoginPage();
        login.enterCredentials();
        login.waitForTodoistMainPage();
        authCookie = login.getUserAuthCookie();
    }

    @Test
    public void userIsLoggedIn() {
        login.userIsLoggedIn(authCookie);
        login.waitForTodoistMainPage();
    }

}
