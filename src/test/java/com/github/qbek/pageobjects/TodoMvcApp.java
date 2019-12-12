package com.github.qbek.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class TodoMvcApp extends PageObject {

    String todoMvcURL = "http://todomvc.com/examples/jquery/#/all";

    public void startApplication() {
        WebDriver browser = getDriver();
        browser.get(todoMvcURL);
        browser.manage().window().maximize();
    }

    public void stopApplication() {
        WebDriver browser = getDriver();
        browser.quit();
    }
}
