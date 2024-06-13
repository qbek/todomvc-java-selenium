package org.example.todomvc.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.openqa.selenium.By.cssSelector;

public class TodoList extends PageObject {
    private By todoListEl = cssSelector(".todo-list");
    private By todoEl = cssSelector(".todo-list li");
    private By completeTodoToggleEl = cssSelector(".toggle");

    public void checkIfTodoOnTheList(String name) {
        var todoList = getDriver().findElement(todoListEl);
        assertThat("Todo is on completed list", todoList.getText(), equalTo(name));
    }

    public void checkIfTodoNOTOnTheList() {
        //jquery solution
//        var todoList = browser.findElement(todoListEl);
//        assertThat("Todo is not on the Active filter list", todoList.getText(), is(emptyString()));
        //angular solution
        var todoList = getDriver().findElements(todoListEl);
        assertThat("Todo is not on the Active filter list", todoList, hasSize(0));
    }

    public void checkIfTodoMarkedAsCompleted() {
        var todoItem = getDriver().findElement(todoEl);
        assertThat("Todo is marked as completed", todoItem.getAttribute("class"), containsString("completed"));
    }

    public void markTodoCompleted() {
        var completeToggle = getDriver().findElement(completeTodoToggleEl);
        completeToggle.click();
    }
}
