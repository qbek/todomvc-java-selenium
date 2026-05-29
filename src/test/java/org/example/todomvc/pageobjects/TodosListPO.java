package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

import java.util.List;

public class TodosListPO extends PageObject {
    private final static By TODO_LIST = By.cssSelector("#todo-list");
    private final static By TODO_ELEMENT = By.cssSelector("#todo-list li");
    private final static By TODO_COMPLETE_TOGGGLE = By.cssSelector(".toggle");


    @Step
    public void completeTodo() {
        var todoCompleteToggle = getDriver().findElement(TODO_COMPLETE_TOGGGLE);
        todoCompleteToggle.click();
    }

    @Step
    public void checkTodoIsOnTheList(String name) {
        var todoLabel = getDriver().findElement(TODO_LIST);
        MatcherAssert.assertThat("Created todo has valid name",
                todoLabel.getText(),
                Matchers.equalTo(name));
    }

    @Step
    public void checkTodoListIsEmpty() {
        var todosList = getDriver().findElement(TODO_LIST);
        MatcherAssert.assertThat("Todos list is empty",
                todosList.getText(),
                Matchers.emptyString());
    }

    @Step
    public void checkTodoMarkedAsCompleted() {
        var todoElement = getDriver().findElement(TODO_ELEMENT);
        MatcherAssert.assertThat("Todo is marked as completed",
                todoElement.getAttribute("class"),
                Matchers.containsString("completed")
        );
    }

    public void checkTodoListContainsAllTodos(List<String> todos) {
        var todosList = getDriver().findElement(TODO_LIST);
        var allTodos = todosList.getText();
        for (var todo :todos) {
            MatcherAssert.assertThat("Todos list contains todo",
                    allTodos,
                    Matchers.containsString(todo));
        }

        var allTodoElements = getDriver().findElements(TODO_ELEMENT);
        MatcherAssert.assertThat("There is correct count of todos",
                allTodoElements,
                Matchers.hasSize(todos.size()));
    }
}
