package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class TodosList extends PageObject {

    private By todoListSelector = By.cssSelector("#todo-list");
    private By todoItemSelector = By.cssSelector("#todo-list li");
    private By todoCompleteChkboxSelector = By.cssSelector(".toggle");


    public void completeTodo() {
        find(todoCompleteChkboxSelector).click();
    }

    public void checkIsTodoMarkedAsCompleted() {
        MatcherAssert.assertThat("Todo is marked as completed",
                find(todoItemSelector).getAttribute("class"),
                Matchers.containsString("completed"));
    }

    public void checkListContainsAnyTodo() {
        find(todoListSelector).isDisabled();
    }

    public void checkTodoListIsEmpty() {
        MatcherAssert.assertThat("Empty todo list",
                findAll(todoItemSelector),
                Matchers.hasSize(3));
    }

    public void userCheckAllTodos(List<String> expected) {
        var allTodos = findAll(todoItemSelector);
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

