package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class TodosList extends PageObject {

    private static final By TODOS_LIST = By.cssSelector(".todo-list");

    @Step
    public void checkIfTodoIsDisplayed(String todoName) {
        find(TODOS_LIST).shouldContainText(todoName);
    }
}
