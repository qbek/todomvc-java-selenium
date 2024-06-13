package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;
import static org.openqa.selenium.By.cssSelector;

public class TodoList extends PageObject {
    private By todoListEl = cssSelector(".todo-list");
    private By todoEl = cssSelector(".todo-list li");
    private By completeTodoToggleEl = cssSelector(".toggle");

    @Step
    public void checkIfTodoOnTheList(String name) {
        find(todoListEl).shouldContainOnlyText(name);
    }

    @Step
    public void checkIfOneOfTodoIsOnTheList(String name) {
        find(todoListEl).shouldContainText(name);
    }

    @Step
    public void checkIfAllTodosAreOnTheList(List<String> expectedTodos) {
        var todos = getDriver().findElements(todoEl);
        var todoNames = new ArrayList<String>();

        for (var todo : todos) {
            todoNames.add(todo.getText());
        }
//        assertThat("All todos are on the list in exact order", todoNames, Matchers.equalTo(expectedTodos));
//        assertThat("All todos are on the list in any order", todoNames, containsInAnyOrder(expectedTodos.toArray()));
        assertThat("At least todos are on the list", todoNames, hasItems(expectedTodos.toArray(new String[expectedTodos.size()])));
    }

    @Step
    public void checkIfTodoNOTOnTheList() {
        //jquery solution
//        var todoList = browser.findElement(todoListEl);
//        assertThat("Todo is not on the Active filter list", todoList.getText(), is(emptyString()));

//        find(todoListEl).shouldContainOnlyText("");
        //angular solution
        find(todoListEl).shouldNotBePresent();
    }

    @Step
    public void checkIfTodoMarkedAsCompleted() {
        assertThat("Todo is marked as completed", find(todoEl).getAttribute("class"), containsString("completed"));
    }

    @Step
    public void markTodoCompleted() {
        find(completeTodoToggleEl).click();
    }
}
