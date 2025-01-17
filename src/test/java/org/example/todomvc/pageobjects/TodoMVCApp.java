package org.example.todomvc.pageobjects;

import org.openqa.selenium.WebDriver;

public class TodoMVCApp {

    WebDriver browser;
    String todoMVCUrl = "https://todomvc.com/examples/jquery/dist/#/all";

    public TodoMVCApp(WebDriver browser) {
        this.browser = browser;
    }

    public void openMainView() {
        browser.get(todoMVCUrl);
    }
}
