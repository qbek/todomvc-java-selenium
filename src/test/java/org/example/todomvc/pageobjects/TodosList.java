package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class TodosList extends PageObject {

    By todosListEl = By.cssSelector("#todo-list");
    By todoItemEl = By.cssSelector("#todo-list li");

    By todoCompleteToggleEl = By.cssSelector(".toggle");

    @Step
    public void checkTodosListIsEmpty() {
        find(todosListEl).shouldContainOnlyText("");
    }

    @Step
    public void checkTodoItemHasCompletedClass() {
                 //sprawdzenie czy element isnieje na stronie (czyste selenium)
        MatcherAssert.assertThat("Completed todo is displayed",
                findAll(By.cssSelector(".completed")),
                Matchers.hasSize(1));

        MatcherAssert.assertThat("Todo is marked as completed",
                find(todoItemEl).getDomAttribute("class"),
                Matchers.containsString("completed"));
    }

    @Step
    public void markTodoAsCompleted() {
        find(todoCompleteToggleEl).select();
    }


    @Step
    public void checkAllTodosAreOnTheList(List<String> expectedNames) {
        var todos = getDriver().findElements(todoItemEl);
        var existingNames = new ArrayList<String>();
        for ( var todo : todos) {
            existingNames.add(todo.getText());
        }

//        MatcherAssert.assertThat("All todos are on the list in exact order", existingNames, Matchers.equalTo(expectedNames));
        MatcherAssert.assertThat("All todos are on the list (order not important)", existingNames, Matchers.containsInAnyOrder(expectedNames.toArray()));
//        MatcherAssert.assertThat("At least todos are on the list (order not important)", existingNames,
//                Matchers.hasItems(expectedNames.toArray(new String[expectedNames.size()])));
    }
}
