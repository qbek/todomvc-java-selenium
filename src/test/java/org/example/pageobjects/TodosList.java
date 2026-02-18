package org.example.pageobjects;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TodosList {

    private By todoListSelector = By.cssSelector("#todo-list");
    private By todoItemSelector = By.cssSelector("#todo-list li");
    private By todoCompleteChkboxSelector = By.cssSelector(".toggle");

    private WebDriver browser;

    public TodosList(WebDriver browser) {
        this.browser = browser;
    }

    public void completeTodo() {
        var el = browser.findElement(todoCompleteChkboxSelector);
        el.click();
    }

    public void checkIsTodoMarkedAsCompleted() {
        var el = browser.findElement(todoItemSelector);
        MatcherAssert.assertThat("Todo is marked as completed",
                el.getAttribute("class"),
                Matchers.containsString("completedxxx"));
    }

    public void checkListContainsAnyTodo() {
        var todoList = browser.findElement(todoListSelector);
        MatcherAssert.assertThat("Todo exists on the list",
                todoList.isDisplayed(),
                Matchers.equalTo(true));
    }

    public void checkTodoListIsEmpty() {
        var el = browser.findElements(todoItemSelector);
        MatcherAssert.assertThat("Empty todo list",
                el,
                Matchers.empty());
    }

    public void checkTodoHasCorrectName(String name) {
        var todoList = browser.findElement(todoListSelector);
        MatcherAssert.assertThat("Todo has correct name",
                todoList.getText(),
                Matchers.containsString(name));
    }

    public void userCheckAllTodos(List<String> expected) {
        var allTodos = browser.findElements(todoItemSelector);
        var todosOnThePage = new ArrayList<String>();
        for (var todo : allTodos) {
            todosOnThePage.add(todo.getText());
        }
        MatcherAssert.assertThat("All todos are on the list in exact order",
                todosOnThePage,
                Matchers.equalTo(expected));
//
//        MatcherAssert.assertThat("All todos are on the list in any order",
//                todosOnThePage,
//                Matchers.containsInAnyOrder(expected.toArray()));

//        MatcherAssert.assertThat("At least todos are on the list",
//                todosOnThePage,
//                Matchers.hasItems(expected.toArray(new String[expected.size()])));
    }
}

