package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.apache.commons.digester.annotations.rules.CallMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TodosList extends PageObject {

    private static final By TODOS_LIST = By.cssSelector(".todo-list");
    private static final By TODO_COMPLETE_BUTTON = By.cssSelector(".todo-list .toggle");
    private static final By COMPLETED_TODO = By.cssSelector(".todo-list .completed");


    @Step
    public void checkIfTodoIsListed(String todoName) {
        find(TODOS_LIST).shouldContainText(todoName);
    }

    @Step
    public void completeTodo() {
        find(TODO_COMPLETE_BUTTON).click();
    }

    @Step
    public void checkIfTodoCompleted() {
        find(COMPLETED_TODO).shouldBePresent();
    }

    public void checkIfTodoIsNotListed(String todoName) {
        find(TODOS_LIST).shouldNotContainText(todoName);
    }
}
