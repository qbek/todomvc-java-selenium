package org.example.todoist;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import static org.openqa.selenium.By.cssSelector;

public class LoginPage extends PageObject {

    private static final By EMAIL_INPUT = cssSelector("#element-0");
    private static final By FOCUSED_ELEMENT = cssSelector(":focus");
    private static final By TOP_BAR = cssSelector("#top_bar_inner");


    @Step
    public void openLoginPage() {
        getDriver().get("https://todoist.com/auth/login");
    }

    @Step
    public void enterCredentials() throws InterruptedException {
        enterEmail();
        enterPassword();
        clickLogin();
    }

    @Step
    public void enterEmail() {
        find(EMAIL_INPUT).typeAndTab("gbinxeqerpnywwysux@awdrt.org");
    }

    @Step
    public void enterPassword() {
        var password = find(FOCUSED_ELEMENT);
        password.typeAndTab("ti4FCvBL39i7mMq");
    }

    @Step
    public void clickLogin() {
        var loginButton = find(FOCUSED_ELEMENT);
        loginButton.click();
    }

    @Step
    public void waitForTodoistMainPage() {
        find(TOP_BAR).waitUntilVisible();
    }

    public Cookie getUserAuthCookie() {
        return getDriver().manage().getCookieNamed("todoistd");
    }

    @Step
    public void userIsLoggedIn(Cookie authCookie) {
        getDriver().get("https://todoist.com/static/favicon-16x16.png");
        getDriver().manage().addCookie(authCookie);
        getDriver().get("https://todoist.com/app/");
    }
}
