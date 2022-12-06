package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

public class TodoMVCApp extends PageObject {

    @Step
    public void openTodoMVCapp() {
        getDriver().get("https://todomvc.com/examples/jquery/#/all");
    }
}
