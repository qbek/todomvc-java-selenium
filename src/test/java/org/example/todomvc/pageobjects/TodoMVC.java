package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;

public class TodoMVC extends PageObject {

    private String todoMvcURL = "https://todomvc.com/examples/angular/dist/browser/#";

    @Step
    public void openApp () {
        getDriver().get(todoMvcURL);
    }
}
