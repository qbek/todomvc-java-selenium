package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;

public class TodoMvcApp extends PageObject {

    public void openTodoMVC() {
        getDriver().get("https://todomvc.com/examples/jquery/#/all");
    }
}
