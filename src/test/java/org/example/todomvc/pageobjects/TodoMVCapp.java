package org.example.todomvc.pageobjects;

import net.serenitybdd.core.pages.PageObject;

public class TodoMVCapp extends PageObject {

    public void openTodoMVC () {
        getDriver().get("https://todomvc.com/examples/angular/dist/browser/#/all");
    }
}
