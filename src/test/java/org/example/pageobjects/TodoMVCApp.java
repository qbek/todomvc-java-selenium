package org.example.pageobjects;

import org.openqa.selenium.WebDriver;

public class TodoMVCApp {

    private WebDriver browser;

    public TodoMVCApp(WebDriver browser) {
        this.browser = browser;
    }

    public void openTodoMVCapp() {
        browser.get("https://todomvc.com/examples/jquery/#/all");
    }
}
