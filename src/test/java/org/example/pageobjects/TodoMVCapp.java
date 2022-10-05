package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;

public class TodoMVCapp extends PageObject {

    public void openApp() {
        getDriver().get("https://todomvc.com/examples/jquery/#/all");
    }
}
