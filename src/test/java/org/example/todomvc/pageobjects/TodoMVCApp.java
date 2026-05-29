package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;

public class TodoMVCApp extends PageObject {
    private final static String TODO_URL = "https://todomvc.com/examples/jquery/dist/#/all";

    @Step
    public void openTodoMVCPage() {
        getDriver().get(TODO_URL);
    }
}
