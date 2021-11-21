package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class TodoMvcApp extends PageObject {

    private final String todoMVC_URL = "https://todomvc.com/examples/jquery/#/all";

    @Step
    public void openTodoMVC() {
        getDriver().get(todoMVC_URL);
    }
}
