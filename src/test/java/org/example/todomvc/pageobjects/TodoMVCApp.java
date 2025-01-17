package org.example.todomvc.pageobjects;

import net.serenitybdd.core.pages.PageObject;

public class TodoMVCApp extends PageObject {


    String todoMVCUrl = "https://todomvc.com/examples/jquery/dist/#/all";

    public void openMainView() {
        getDriver().get(todoMVCUrl);
    }
}
