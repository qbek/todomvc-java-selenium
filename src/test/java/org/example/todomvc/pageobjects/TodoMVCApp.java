package org.example.todomvc.pageobjects;

import org.openqa.selenium.WebDriver;

public class TodoMVCApp {
    private final static String TODO_URL = "https://todomvc.com/examples/jquery/dist/#/all";
    private WebDriver browser;

    public TodoMVCApp(WebDriver browser) {
        this.browser = browser;
    }

    public void openTodoMVCPage() {
        browser.get(TODO_URL);
    }
}
