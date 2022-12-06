package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WithByLocator;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.openqa.selenium.By.cssSelector;

public class TodosList extends PageObject {

    private static final By TODOS_LIST = cssSelector(".todo-list");
    private static final By TODO = cssSelector(".todo-list li");
    private static final By TODO_COMPLETE_TOGGLE = cssSelector(".toggle");

    @Step
    public void checkIfTodoDisplayed (String name) {
        find(TODOS_LIST).shouldContainOnlyText(name);
    }

    @Step
    public void checkIfTodoNOTDisplayed (String name) {
        find(TODOS_LIST).shouldNotContainText(name);
    }

    @Step
    public void checkIfTodoCompleted () {
        assertThat("Todo is marked as completed", find(TODO).getAttribute("class"), equalTo("completed"));
    }

    @Step
    public void completeTodo() {
        find(TODO_COMPLETE_TOGGLE).click();
    }
}
