package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

public class TodosList extends PageObject {

    By todosListEl = By.cssSelector("#todo-list");
    By todoItemEl = By.cssSelector("#todo-list li");

    By todoCompleteToggleEl = By.cssSelector(".toggle");

    @Step
    public void checkTodoIsOnTheList(String name) {
        find(todosListEl).shouldContainOnlyText("ggg");
    }

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
}
