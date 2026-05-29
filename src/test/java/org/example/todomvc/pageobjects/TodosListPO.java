package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class TodosListPO extends PageObject {
    private final static By TODO_LIST = By.cssSelector("#todo-list");
    private final static By TODO_ELEMENT = By.cssSelector("#todo-list li");
    private final static By TODO_COMPLETE_TOGGGLE = By.cssSelector(".toggle");


    @Step
    public void completeTodo() {
        find(TODO_COMPLETE_TOGGGLE).click();
    }

    @Step
    public void checkTodoListIsEmpty() {
        MatcherAssert.assertThat("Todos list is empty",
                find(TODO_LIST).getText(),
                Matchers.emptyString());
    }

    @Step
    public void checkTodoMarkedAsCompleted() {
        MatcherAssert.assertThat("Todo is marked as completed",
                find(TODO_ELEMENT).getAttribute("class"),
                Matchers.containsString("completed")
        );
    }

    @Step
    public void checkTodoListContainsAllTodos(List<String> expectedTodos) {
        var todosElements = getDriver().findElements(TODO_ELEMENT);
        var todosLabels = new ArrayList<String>();

        for (var todoEl : todosElements) {
            todosLabels.add(todoEl.getText());
        }

        MatcherAssert.assertThat("All todos are on the list in exact order",
                todosLabels,
                Matchers.equalTo(expectedTodos));

//        MatcherAssert.assertThat("All todos but in any order",
//                todosLabels,
//                Matchers.containsInAnyOrder(expectedTodos.toArray()));

//        MatcherAssert.assertThat("At least todos are on the list",
//                todosLabels,
//                Matchers.hasItems(expectedTodos.toArray(new String[0])));

    }
}
