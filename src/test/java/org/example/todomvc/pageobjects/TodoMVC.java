package org.example.todomvc.pageobjects;

import net.serenitybdd.core.pages.PageObject;

public class TodoMVC extends PageObject {

    private String todoMvcURL = "https://todomvc.com/examples/angular/dist/browser/#";

    public void openApp () {
        getDriver().get(todoMvcURL);
    }
}
